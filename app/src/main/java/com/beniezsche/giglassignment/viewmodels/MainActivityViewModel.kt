package com.beniezsche.giglassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.beniezsche.giglassignment.models.FeedItem
import com.beniezsche.giglassignment.repository.ItemRepository

class MainActivityViewModel(private val itemRepository: ItemRepository) : ViewModel() {
    fun getData() : LiveData<List<FeedItem>> {
        return itemRepository.getData()
    }
}