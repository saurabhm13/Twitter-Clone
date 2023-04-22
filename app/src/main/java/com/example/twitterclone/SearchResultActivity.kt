package com.example.twitterclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.TabStopSpan
import androidx.viewpager.widget.ViewPager
import com.example.twitterclone.Fragments.Search.ResultViewPagerAdapter.SearchResultViewPagerAdapter
import com.example.twitterclone.Fragments.ViewPageAdapter.HomeViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class SearchResultActivity : AppCompatActivity() {

    lateinit var searchResultTabLayout: TabLayout
    lateinit var searchResultViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        // Inflate the layout for this fragment

        searchResultViewPager = findViewById(R.id.searchResultViewPager)
        searchResultViewPager.adapter = SearchResultViewPagerAdapter(supportFragmentManager)

        searchResultTabLayout = findViewById(R.id.searchResultTabLayout)
        searchResultTabLayout.setupWithViewPager(searchResultViewPager)

    }
}