package com.beniezsche.giglassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beniezsche.giglassignment.models.FeedItem
import com.beniezsche.giglassignment.networking.ApiService
import com.beniezsche.giglassignment.networking.RetrofitClient
import com.beniezsche.giglassignment.repository.ItemRepository
import retrofit2.Call
import retrofit2.Response

class MainActivityViewModel(private val itemRepository: ItemRepository) : ViewModel() {

    fun getData() : LiveData<List<FeedItem>> {
        return itemRepository.getData()
    }


}