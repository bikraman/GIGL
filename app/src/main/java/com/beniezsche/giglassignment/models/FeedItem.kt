package com.beniezsche.giglassignment.models

import com.google.gson.annotations.SerializedName

data class FeedItem(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("type")
    var type: String,
    @SerializedName("content")
    var content: String?,
    @SerializedName("contents")
    var imageLists: List<String>? = null
)
