package com.example.twitterclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.twitterclone.Fragments.ViewPageAdapter.HomeViewPagerAdapter
import com.example.twitterclone.R
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    lateinit var homeTabLayout: TabLayout
    lateinit var homeViewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        homeViewPager = view.findViewById(R.id.homeViewPager)
        homeViewPager.adapter = HomeViewPagerAdapter(childFragmentManager)

        homeTabLayout = view.findViewById(R.id.homeTabLayout)
        homeTabLayout.setupWithViewPager(homeViewPager)


        return view
    }

}