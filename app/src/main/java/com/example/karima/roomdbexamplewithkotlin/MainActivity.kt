package com.example.karima.roomdbexamplewithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var database:AppDataBase
    private lateinit var dao:EntityDataAccessObject
    private lateinit var entityListTitle:EntityListTitle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database= AppDataBase.getInstance(context = this)
        dao=database.entityDao()
        addEntity()
        submit_button.setOnClickListener({
            addEntity()
         })
    }

    private fun addEntity(){
        val title=entityTitle.text.toString()
        if(title.isBlank()) run {
            Toast.makeText(applicationContext, "please Enter Title", Toast.LENGTH_LONG)
            return
        }
       val entity=Entity(title=title)
        thread {
            dao.insert(entity)
        }
    }
}
