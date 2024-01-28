package com.beniezsche.giglassignment.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "feed_item")
data class FeedItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("type")
    @ColumnInfo("type")
    var type: String,
    @SerializedName("content")
    @ColumnInfo("content")
    var content: String?,

) {
    @SerializedName("contents")
    @Ignore
    var imageLists: List<String>? = null
}
