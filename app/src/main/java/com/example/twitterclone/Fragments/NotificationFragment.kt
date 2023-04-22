package com.example.twitterclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.twitterclone.Fragments.ViewPageAdapter.NotificationViewPagerAdapter
import com.example.twitterclone.R
import com.google.android.material.tabs.TabLayout

class NotificationFragment : Fragment() {

    lateinit var notificationTabLayout: TabLayout
    lateinit var notificationViewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        notificationTabLayout = view.findViewById(R.id.notificationTabLayout)
        notificationViewPager = view.findViewById(R.id.notificationViewPager)

        notificationViewPager.adapter = NotificationViewPagerAdapter(childFragmentManager)
        notificationTabLayout.setupWithViewPager(notificationViewPager)

        return view
    }


}