package com.example.twitterclone.Fragments.ViewPageAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.twitterclone.Fragments.*

class MainViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                SearchFragment()
            }
            2 -> {
                SpacesFragment()
            }
            3 -> {
                NotificationFragment()
            }
            4 -> {
                MessageFragment()
            }
            else -> {
                HomeFragment()
            }
        }
    }

}
