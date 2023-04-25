package com.example.twitterclone.Fragments.profile.ProfileViewPagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.twitterclone.Fragments.Search.SearchResult.*
import com.example.twitterclone.Fragments.profile.ProfileLikesFragment
import com.example.twitterclone.Fragments.profile.ProfileMediaFragment
import com.example.twitterclone.Fragments.profile.ProfileTweetsAndReplyFragment
import com.example.twitterclone.Fragments.profile.ProfileTweetsFragment

class ProfileViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 4;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                ProfileTweetsFragment()
            }
            1 -> {
                ProfileTweetsAndReplyFragment()
            }
            2 -> {
                ProfileMediaFragment()
            }
            3 -> {
                ProfileLikesFragment()
            }
            else -> {
                ProfileTweetsFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tweets"
            }
            1 -> {
                return "Tweets & Reply"
            }
            2 -> {
                return "Media"
            }
            3 -> {
                return "Likes"
            }
        }
        return super.getPageTitle(position)
    }

}
