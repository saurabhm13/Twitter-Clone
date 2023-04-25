package com.example.twitterclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.twitterclone.Fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var mainViewPager: ViewPager
    lateinit var bottomNavView: BottomNavigationView
    lateinit var mainFAB: ExtendedFloatingActionButton
    lateinit var btnTextUI: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        replaceFragment(HomeFragment())

        mainFAB.setOnClickListener(View.OnClickListener {

            val currentFragment = supportFragmentManager.findFragmentById(R.id.frameLayout)

            if (currentFragment is SpacesFragment) {
                // perform action for Fragment1
                Toast.makeText(this@MainActivity, "spaces", Toast.LENGTH_SHORT).show()

            } else if (currentFragment is MessageFragment) {
                // perform action for Fragment2
                Toast.makeText(this@MainActivity, "Message", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity, "New Tweet", Toast.LENGTH_SHORT).show()
            }

//            val inToSearchResult = Intent(this, SearchResultActivity::class.java)
//            startActivity(inToSearchResult)
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

        btnTextUI.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, NewTweetActivity::class.java)
            startActivity(intent)
        })

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

        btnTextUI = findViewById(R.id.btnTestUI)
    }
}