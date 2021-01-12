package com.example.randomnumadapter_recyclerview_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Predicate

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), RandomNumListAdapter.OnItemClickListener {


    private lateinit var recyclerView: RecyclerView

    val presidents: MutableList<President> = GlobalModel.presidents

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)

        //Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        recyclerView.adapter = RandomNumListAdapter(presidents, this)

        return view
    }

    override fun onItemClick(position: Int) {
        val clickedItem: President = presidents[position]

        clickedItem.name = "Clicked"

        recyclerView.adapter?.notifyItemChanged(position)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}