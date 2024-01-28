package com.beniezsche.giglassignment.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: ApiService? = null
    private const val baseUrl = "https://65b62d2bda3a3c16ab004fe2.mockapi.io";
    fun getClient(): ApiService? {

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
        return retrofit
    }
}