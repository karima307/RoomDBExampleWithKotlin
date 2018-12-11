package com.example.karima.roomdbexamplewithkotlin

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by Karima on 12/10/2018.
 */


/**
 *@param version = the version number of the database
 *
 */

@Database(version = 1, entities = [
//list DB entities
])
abstract class AppDataBase : RoomDatabase() {
    //create method for get a new instance of class
    //@volatile -> meaning that make that obj visible to other threads
    //synchronized to protect the obj from concurrent by multiple threads
    companion object {
        @Volatile private var INSTANCE: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDataBase {
            return Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "user")
                    .build()
        }

    }
}