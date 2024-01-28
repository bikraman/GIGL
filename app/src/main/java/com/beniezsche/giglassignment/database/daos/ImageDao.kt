package com.beniezsche.giglassignment.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.beniezsche.giglassignment.models.FeedItem
import com.beniezsche.giglassignment.models.ImageItem

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<ImageItem>)

    @Query("SELECT * FROM image_item_table WHERE item_id = :itemId")
    fun getNestedImages(itemId: Int) : List<ImageItem>


}