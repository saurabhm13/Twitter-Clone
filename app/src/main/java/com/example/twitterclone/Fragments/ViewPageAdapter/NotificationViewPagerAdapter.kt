package com.example.twitterclone.Fragments.ViewPageAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.twitterclone.Fragments.Home.HomeFollowingFragment
import com.example.twitterclone.Fragments.Home.HomeForYouFragment
import com.example.twitterclone.Fragments.Notification.NotificationAllFragment
import com.example.twitterclone.Fragments.Notification.NotificationMentionsFragment
import com.example.twitterclone.Fragments.Notification.NotificationVerifiedFragment

class NotificationViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                NotificationAllFragment()
            }
            1 -> {
                NotificationVerifiedFragment()
            }
            2 -> {
                NotificationMentionsFragment()
            }
            else -> {
                NotificationAllFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "All"
            }
            1 -> {
                return "Verified"
            }
            2 -> {
                return "Mentions"
            }
        }
        return super.getPageTitle(position)
    }

}