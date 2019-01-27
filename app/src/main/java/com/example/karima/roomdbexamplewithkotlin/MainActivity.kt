package com.example.karima.roomdbexamplewithkotlin

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var database: AppDataBase
    private lateinit var dao: EntityDataAccessObject
    private val entityList = ArrayList<Entity>()
    private val entityListFromDb = ArrayList<Entity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = AppDataBase.getInstance(context = this)
        dao = database.entityDao()
        submit_button.setOnClickListener { addEntity() }
        select_all.setOnClickListener {
            dao.getAll().observe(this, Observer {
                it?.forEach {
                    entityListFromDb.add(it)
                    initRecyclerUi(entityListFromDb)

                }
            })
        }

    }

    private fun addEntity() {
        val title = entityTitle.text.toString()
        if (title.isBlank()) run {
            Toast.makeText(applicationContext, "please Enter Title", Toast.LENGTH_LONG)
            return
        }
        val entity = Entity(title = title)
        entityList.add(Entity(title = title))
        initRecyclerUi(entityList)
        thread {
            dao.insert(entity)
        }
    }

    private fun initRecyclerUi(entityList: ArrayList<Entity>) {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EntityListTitleAdapter(entityList)
    }
}
