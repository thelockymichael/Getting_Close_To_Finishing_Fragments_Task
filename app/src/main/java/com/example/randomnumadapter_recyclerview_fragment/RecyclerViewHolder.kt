package com.example.randomnumadapter_recyclerview_fragment

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    val view: TextView = itemView.findViewById(R.id.randomText)

}