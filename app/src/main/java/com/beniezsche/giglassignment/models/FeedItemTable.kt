package com.beniezsche.giglassignment.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "feed_table")
data class FeedItemTable(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    @ColumnInfo("type")
    var type: String,
    @ColumnInfo("content")
    var content: String?,
)
