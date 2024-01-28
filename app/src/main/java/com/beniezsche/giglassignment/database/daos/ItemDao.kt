package com.beniezsche.giglassignment.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.beniezsche.giglassignment.models.FeedItemTable

@Dao
interface ItemDao {

    @Upsert
    fun insertAll(items: List<FeedItemTable>)

    @Query("SELECT * FROM feed_table")
    fun getItems() : List<FeedItemTable>


}