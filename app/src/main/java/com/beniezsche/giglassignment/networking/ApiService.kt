package com.beniezsche.giglassignment.networking

import com.beniezsche.giglassignment.models.FeedItem
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("/items")
    fun getItems(): Call<List<FeedItem>>
}