package com.example.twitterclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.twitterclone.Fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var mainViewPager: ViewPager
    lateinit var bottomNavView: BottomNavigationView
    lateinit var mainFAB: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        replaceFragment(HomeFragment())

        mainFAB.setOnClickListener(View.OnClickListener {

            val inToSearchResult = Intent(this, SearchResultActivity::class.java)
            startActivity(inToSearchResult)
        })

        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeBN -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.searchBN -> {
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.micBN -> {
                    replaceFragment(SpacesFragment())
                    true
                }
                R.id.notificationBN -> {
                    replaceFragment(NotificationFragment())
                    true
                }
                R.id.messageBN -> {
                    replaceFragment(MessageFragment())
                    true
                }
                else -> {
                    replaceFragment(HomeFragment())
                    true
                }
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }

    private fun initData() {
        bottomNavView = findViewById(R.id.bottom_navigation)

        mainViewPager = findViewById(R.id.mainViewPager)
        mainFAB = findViewById(R.id.mainFAB)
    }
}