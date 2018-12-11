package com.example.karima.roomdbexamplewithkotlin

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.entity_detail.view.*

/**
 * Created by Karima on 12/10/2018.
 */
class EntityListTitle : LinearLayout {
    constructor(context: Context):super(context)
    constructor(context: Context,attrs:AttributeSet):super(context,attrs)
    init {
        LayoutInflater.from(context).inflate(R.layout.entity_detail,this,false)

    }
}