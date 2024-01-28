package com.beniezsche.giglassignment.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feed_table")
data class FeedItemTable(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    @ColumnInfo("type")
    var type: String,
    @ColumnInfo("content")
    var content: String?,
)
