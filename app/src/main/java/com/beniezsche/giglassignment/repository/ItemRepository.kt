package com.beniezsche.giglassignment.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beniezsche.giglassignment.database.DatabaseInstance
import com.beniezsche.giglassignment.models.FeedItem
import com.beniezsche.giglassignment.networking.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemRepository(private val applicationContext: Context) {

    private val online = true

    fun getData() : LiveData<List<FeedItem>> {

        val database = DatabaseInstance.getDatabaseInstance(applicationContext)
        val retrofit = RetrofitClient.getClient()

        val data = MutableLiveData<List<FeedItem>>()

        if (online) {

            retrofit?.getItems()?.enqueue(object : Callback<List<FeedItem>>{
                override fun onResponse(
                    call: Call<List<FeedItem>>,
                    response: Response<List<FeedItem>>
                ) {
                    if (response.isSuccessful)
                        data.value = response.body()
                }

                override fun onFailure(call: Call<List<FeedItem>>, t: Throwable) {
                    data.value = null
                }

            })
        }
        else {
            val items = database.itemDao().getItems()
            data.value = items
        }

        return data
    }
}