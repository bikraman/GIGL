package com.beniezsche.giglassignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.beniezsche.giglassignment.R
import com.beniezsche.giglassignment.adapters.FeedAdapter
import com.beniezsche.giglassignment.models.FeedItem
import com.beniezsche.giglassignment.repository.ItemRepository
import com.beniezsche.giglassignment.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var feedAdapter: FeedAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        feedAdapter = FeedAdapter()

        val itemRepository = ItemRepository(applicationContext)

        mainActivityViewModel = MainActivityViewModel(itemRepository)
        val feedList :RecyclerView = findViewById(R.id.feedList);
        feedList.adapter = feedAdapter

        mainActivityViewModel.getData().observe(this, Observer {
            onPopulateList(it)
        })

    }

    private fun onPopulateList(feedItems: List<FeedItem>) {

        feedAdapter.feedItems = feedItems;
        feedAdapter.notifyDataSetChanged();
    }
}