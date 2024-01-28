package com.beniezsche.giglassignment.database

import android.content.Context
import androidx.room.Room

object DatabaseInstance {

    private lateinit var DB_INSTANCE : ApplicationDatabase

    fun getDatabaseInstance(applicationContext: Context): ApplicationDatabase {

        return if (!::DB_INSTANCE.isInitialized) {
            DB_INSTANCE = Room.databaseBuilder(
                applicationContext,
                ApplicationDatabase::class.java,
                "app-database"
            ).build()

            DB_INSTANCE
        } else
            DB_INSTANCE
    }
}