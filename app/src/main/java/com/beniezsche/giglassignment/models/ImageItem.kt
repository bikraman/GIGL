package com.beniezsche.giglassignment.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_item_table")
data class ImageItem (
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    @ColumnInfo("item_id")
    val itemId: Int,
    @ColumnInfo("image")
    val image: String
)