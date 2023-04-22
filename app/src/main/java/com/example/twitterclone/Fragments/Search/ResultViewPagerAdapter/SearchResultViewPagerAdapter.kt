package com.example.twitterclone.Fragments.Search.ResultViewPagerAdapter

import android.provider.ContactsContract.Contacts.Photo
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.twitterclone.Fragments.Home.HomeFollowingFragment
import com.example.twitterclone.Fragments.Home.HomeForYouFragment
import com.example.twitterclone.Fragments.Search.SearchResult.*

class SearchResultViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 5;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                TopSearchResultFragment()
            }
            1 -> {
                LatestSearchResultFragment()
            }
            2 -> {
                PeopleSearchResultFragment()
            }
            3 -> {
                PhotosSearchResultFragment()
            }
            4 -> {
                VideosSearchResultFragment()
            }
            else -> {
                TopSearchResultFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Top"
            }
            1 -> {
                return "latest"
            }
            2 -> {
                return "People"
            }
            3 -> {
                return "Photos"
            }
            4 -> {
                return "Videos"
            }
        }
        return super.getPageTitle(position)
    }

}
