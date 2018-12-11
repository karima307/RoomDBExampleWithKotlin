package com.example.karima.roomdbexamplewithkotlin

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Karima on 12/10/2018.
 */
@Entity
data class Entity(@PrimaryKey(autoGenerate = true) var id: Int = 0, var title: String = "", var isCompleted: Boolean = false)