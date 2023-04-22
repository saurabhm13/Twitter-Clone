package com.example.twitterclone.Fragments.ViewPageAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.twitterclone.Fragments.Home.HomeFollowingFragment
import com.example.twitterclone.Fragments.Home.HomeForYouFragment

class HomeViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                HomeForYouFragment()
            }
            1 -> {
                HomeFollowingFragment()
            }
            else -> {
                HomeForYouFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "For You"
            }
            1 -> {
                return "Following"
            }
        }
        return super.getPageTitle(position)
    }

}
