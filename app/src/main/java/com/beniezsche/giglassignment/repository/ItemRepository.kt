package com.beniezsche.giglassignment.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beniezsche.giglassignment.database.ApplicationDatabase
import com.beniezsche.giglassignment.database.DatabaseInstance
import com.beniezsche.giglassignment.models.FeedItem
import com.beniezsche.giglassignment.models.FeedItemTable
import com.beniezsche.giglassignment.models.ImageItem
import com.beniezsche.giglassignment.networking.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemRepository(private val applicationContext: Context) {
    fun getData() : LiveData<List<FeedItem>> {

        val database = DatabaseInstance.getDatabaseInstance(applicationContext)
        val retrofit = RetrofitClient.getClient()

        val data = MutableLiveData<List<FeedItem>>()

        retrofit?.getItems()?.enqueue(object : Callback<List<FeedItem>>{
            override fun onResponse( call: Call<List<FeedItem>>, response: Response<List<FeedItem>> ) {
                if (response.isSuccessful) {
                    val res = response.body()

                    if (res != null) {
                        data.value = res
                        convertItemsToDbItemsAndInsertToDb(res, database)
                    }
                }
            }

            override fun onFailure(call: Call<List<FeedItem>>, t: Throwable) {
                CoroutineScope(Dispatchers.IO).launch {
                    val itemsFromDb = getItemsFromDb(database)
                    data.postValue(itemsFromDb)
                }
            }
        })

        return data
    }


    private fun convertItemsToDbItemsAndInsertToDb(res: List<FeedItem>, database: ApplicationDatabase) {

        val tempImageList = ArrayList<ImageItem>()
        val tempItemList = ArrayList<FeedItemTable>()

        for (item in res) {
            if (item.type == "nested_item") {
                val imgLst = item.imageLists?.mapIndexed { index, imageLink ->
                    ImageItem( "${item.id}$index".toInt() , item.id, imageLink )
                }
                tempImageList.addAll(imgLst!!)
            }

            tempItemList.add(FeedItemTable(item.id, item.type, item.content ))
        }

        CoroutineScope(Dispatchers.IO).launch {
            database.itemDao().insertAll(tempItemList)
            database.imageDao().insertAll(tempImageList)
        }

    }

    private fun getItemsFromDb(database: ApplicationDatabase) : List<FeedItem> {

        val items = database.itemDao().getItems()

        val feedItems = items.map { feedItemTable ->

            var imageItems: List<String>? = null

            if (feedItemTable.type == "nested_item") {
                imageItems = database.imageDao().getNestedImages(feedItemTable.id).map { imageItem -> imageItem.image  }
            }

            FeedItem(feedItemTable.id, feedItemTable.type, feedItemTable.content, imageItems)
        }

        return feedItems
    }
}