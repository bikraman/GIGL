package com.beniezsche.giglassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.beniezsche.giglassignment.R
import com.beniezsche.giglassignment.models.FeedItem
import com.bumptech.glide.Glide

class NestedFeedAdapter : RecyclerView.Adapter<NestedFeedAdapter.ItemViewHolder>() {

    var images : List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_item_image, parent, false);
        return ItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image = images[position]
        Glide.with(holder.itemView.context).load(image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return images.size
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imageView);
    }
}