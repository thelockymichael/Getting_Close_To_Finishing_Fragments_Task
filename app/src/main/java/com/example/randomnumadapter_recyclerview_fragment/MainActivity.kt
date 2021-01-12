package com.example.randomnumadapter_recyclerview_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*

class MainActivity : AppCompatActivity(), PresidentListAdapter.OnItemClickListener {


    private lateinit var secondFragment: Fragment
    private lateinit var firstFragment: Fragment
    private val presidents: MutableList<President> = GlobalModel.presidents


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secondFragment = SecondFragment(this, presidents)

        // Change FrameLayout into First Fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, secondFragment)
            commit()
        }
    }

    override fun onItemClick(position: Int) {
        val clickedItem: President = presidents[position]


        secondFragment.recyclerview.adapter?.notifyItemChanged(position)

        firstFragment = FirstFragment(clickedItem, supportFragmentManager.popBackStackImmediate())

        // Change FrameLayout into First Fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            addToBackStack(null)
            commit()
        }
    }
}