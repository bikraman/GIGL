package com.beniezsche.giglassignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.beniezsche.giglassignment.database.daos.ItemDao
import com.beniezsche.giglassignment.models.FeedItem

@Database(entities = [FeedItem::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun itemDao() : ItemDao

}