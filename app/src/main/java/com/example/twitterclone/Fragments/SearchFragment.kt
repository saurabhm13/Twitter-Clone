package com.example.twitterclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.twitterclone.Fragments.ViewPageAdapter.SearchViewPageAdapter
import com.example.twitterclone.R
import com.google.android.material.tabs.TabLayout

class SearchFragment : Fragment() {

    lateinit var searchTabLayout: TabLayout
    lateinit var searchViewPager: ViewPager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_search, container, false)

        searchTabLayout = view.findViewById(R.id.searchTabLayout)
        searchViewPager = view.findViewById(R.id.searchViewPager)

        searchViewPager.adapter = SearchViewPageAdapter(childFragmentManager)
        searchTabLayout.setupWithViewPager(searchViewPager)


        return view
    }

}