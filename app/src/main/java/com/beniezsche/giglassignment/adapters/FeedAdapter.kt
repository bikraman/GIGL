package com.beniezsche.giglassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.beniezsche.giglassignment.R
import com.beniezsche.giglassignment.models.FeedItem
import com.bumptech.glide.Glide

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val ITEM = 0;
    val NESTED_ITEM = 1;

    var feedItems : List<FeedItem> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.feed_item, parent, false);
                return ItemViewHolder(view)
            }
            NESTED_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.feed_item_nested, parent, false);
                return NestedItemViewHolder(view)
            }
        }
        return super.createViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return when (feedItems[position].type) {
            "nested_item" -> NESTED_ITEM
            else -> ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {
            is ItemViewHolder -> {
                val feedItem = feedItems[position]
                Glide.with(holder.itemView.context).load(feedItem.content).into(holder.imageView)
            }
            is NestedItemViewHolder -> {
                val feedItem = feedItems[position]
                feedItem.imageLists?.let {
                    holder.setImages(it)
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return feedItems.size
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imageView);
    }

    class NestedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rv_nested: RecyclerView = itemView.findViewById(R.id.rv_nested_images);


        fun setImages(images: List<String>) {
            val nestedAdapter = NestedFeedAdapter()
            rv_nested.adapter = nestedAdapter
            nestedAdapter.images = images
            nestedAdapter.notifyDataSetChanged()
        }
    }
}