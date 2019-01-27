package com.example.karima.roomdbexamplewithkotlin

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by Karima on 12/10/2018.
 */
@Dao
interface EntityDataAccessObject{
    @Insert
    fun insert(entity: Entity):Long
    @Insert
    fun insertAll(listOfEntity: List<Entity>):List<Long>
    @Query("SELECT * FROM Employee")
    fun getAll():LiveData<List<Entity>>

}