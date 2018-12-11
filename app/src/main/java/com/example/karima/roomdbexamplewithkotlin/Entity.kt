package com.example.karima.roomdbexamplewithkotlin

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Karima on 12/10/2018.
 */
@Entity(tableName = "Employee")
data class Entity(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                  @ColumnInfo(name = "Employee Info") var title: String = "",
                  var isCompleted: Boolean = false)