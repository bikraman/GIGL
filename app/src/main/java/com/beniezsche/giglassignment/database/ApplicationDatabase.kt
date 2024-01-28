package com.beniezsche.giglassignment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beniezsche.giglassignment.database.daos.ImageDao
import com.beniezsche.giglassignment.database.daos.ItemDao
import com.beniezsche.giglassignment.models.FeedItemTable
import com.beniezsche.giglassignment.models.ImageItem

@Database(entities = [FeedItemTable::class, ImageItem::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun itemDao() : ItemDao
    abstract fun imageDao() : ImageDao

}