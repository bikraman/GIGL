package com.beniezsche.giglassignment.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.beniezsche.giglassignment.models.FeedItem

@Dao
interface ItemDao {

    @Insert
    fun insertItems(vararg items: FeedItem)

    @Query("SELECT * FROM feed_item")
    fun getItems() : List<FeedItem>


}