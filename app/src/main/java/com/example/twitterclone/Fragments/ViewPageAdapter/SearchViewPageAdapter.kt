package com.example.twitterclone.Fragments.ViewPageAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.twitterclone.Fragments.Home.HomeFollowingFragment
import com.example.twitterclone.Fragments.Home.HomeForYouFragment
import com.example.twitterclone.Fragments.Search.SearchForYouFragment
import com.example.twitterclone.Fragments.Search.SearchNewsFragment
import com.example.twitterclone.Fragments.Search.SearchTrendingFragment

class SearchViewPageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                SearchForYouFragment()
            }
            1 -> {
                SearchTrendingFragment()
            }
            3 ->
            {
                SearchNewsFragment()
            }
            else -> {
                SearchForYouFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "For You"
            }
            1 -> {
                return "Trending"
            }
            2 -> {
                return "News"
            }
        }
        return super.getPageTitle(position)
    }

}
