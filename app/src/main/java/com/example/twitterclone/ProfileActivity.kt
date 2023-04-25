package com.example.twitterclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.twitterclone.Fragments.Search.ResultViewPagerAdapter.SearchResultViewPagerAdapter
import com.example.twitterclone.Fragments.profile.ProfileViewPagerAdapter.ProfileViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class ProfileActivity : AppCompatActivity() {

    lateinit var profileTabLayout: TabLayout
    lateinit var profileViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileTabLayout = findViewById(R.id.profileTabLayout)
        profileViewPager = findViewById(R.id.profileViewPager)

        profileViewPager.adapter = ProfileViewPagerAdapter(supportFragmentManager)

        profileTabLayout.setupWithViewPager(profileViewPager)
    }
}