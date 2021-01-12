package com.example.randomnumadapter_recyclerview_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment(
    private val presidentDetails: President,
    private var popBackStackImmediate: Boolean
): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        view.presidentName.text = presidentDetails.name
        view.presidency.text = "In office: ${presidentDetails.startOfPresidency} - ${presidentDetails.endOfPresidency} "
        view.whichPresident.text = "${presidentDetails.whichPresident}"

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         view.findViewById<Button>(R.id.backButton).setOnClickListener {
             popBackStackImmediate = true
         }
    }
}