package com.thesis.week5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    constructor(parent: ViewGroup)
        :this(LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item_view,parent,false))
}