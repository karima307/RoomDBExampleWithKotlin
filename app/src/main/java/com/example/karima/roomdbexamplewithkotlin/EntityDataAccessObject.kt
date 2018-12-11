package com.example.karima.roomdbexamplewithkotlin

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert

/**
 * Created by Karima on 12/10/2018.
 */
@Dao
interface EntityDataAccessObject{
    @Insert
    fun insert(entity: Entity):Long
    @Insert
    fun insertAll(listOfEntity: List<Entity>):List<Long>


}