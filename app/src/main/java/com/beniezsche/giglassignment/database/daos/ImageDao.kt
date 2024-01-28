package com.beniezsche.giglassignment.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.beniezsche.giglassignment.models.ImageItem

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<ImageItem>)

    @Query("SELECT * FROM image_item_table WHERE item_id = :itemId")
    fun getNestedImages(itemId: Int) : List<ImageItem>


}