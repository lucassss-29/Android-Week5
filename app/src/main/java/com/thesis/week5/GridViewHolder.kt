package com.thesis.week5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    constructor(parent: ViewGroup)
        :this(LayoutInflater.from(parent.context).inflate(R.layout.restaurant_grid_view, parent, false))
}