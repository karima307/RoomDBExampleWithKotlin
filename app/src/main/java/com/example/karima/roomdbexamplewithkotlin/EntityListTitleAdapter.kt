package com.example.karima.roomdbexamplewithkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.entity_detail.view.*

/**
 * Created by Karima on 12/10/2018.
 */
class EntityListTitleAdapter(val entityList: List<Entity>) : RecyclerView.Adapter<EntityListTitleAdapter.EntityViewHolder>() {
    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.entityTitle.text = entityList[position].title
    }

    override fun getItemCount(): Int {
        return entityList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val inflateEntity = LayoutInflater.from(parent?.context).inflate(R.layout.entity_detail, parent, false)
        return EntityViewHolder(inflateEntity)
    }

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val entityTitle = itemView.findViewById<TextView>(R.id.title)
    }
}