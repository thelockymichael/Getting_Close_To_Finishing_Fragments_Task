package com.example.randomnumadapter_recyclerview_fragment

import android.provider.Settings
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class RandomNumListAdapter(seed: Int) : RecyclerView.Adapter<RecyclerViewHolder>() {
    private val random: Random = Random(seed.toLong())



    override fun getItemViewType(position: Int): Int {
        return R.layout.frame_textview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        val president: President = GlobalModel.presidents[position]

        holder.view.text = president.name

//        holder.view.text = random.nextInt().toString()


    }

    override fun getItemCount(): Int {
        return GlobalModel.presidents.size
    }

}