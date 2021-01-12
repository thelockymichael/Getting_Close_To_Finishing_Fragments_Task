package com.example.randomnumadapter_recyclerview_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class PresidentListAdapter(
    private val presidents: MutableList<President>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<PresidentListAdapter.RecyclerViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return R.layout.frame_textview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        val president: President = presidents[position]

        holder.view.text = "${president.name}, ${president.startOfPresidency} - ${president.endOfPresidency}"
    }

     override fun getItemCount(): Int {
        return GlobalModel.presidents.size
    }

    inner class RecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val view: TextView = itemView.findViewById(R.id.randomText)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}

