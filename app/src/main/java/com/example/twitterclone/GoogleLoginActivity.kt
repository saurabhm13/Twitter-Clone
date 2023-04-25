package com.example.twitterclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class GoogleLoginActivity : AppCompatActivity() {

    lateinit var btn_continueWithGoogle: Button
    lateinit var btn_CreateAccount: Button
    lateinit var btnTxt_login: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_login)

        initData()

        btn_CreateAccount.setOnClickListener(View.OnClickListener {
            val inToSignupActivity = Intent(this, SignupActivity::class.java)
            startActivity(inToSignupActivity)
        })

        btnTxt_login.setOnClickListener(View.OnClickListener {
            val inToLoginActivity = Intent(this, LoginActivity::class.java)
            startActivity(inToLoginActivity)
        })
    }

    fun initData(){
        btnTxt_login = findViewById(R.id.btnTxt_login)
        btn_CreateAccount = findViewById(R.id.btn_create_account)
        btn_continueWithGoogle = findViewById(R.id.btn_continueWithGoogle)
    }
}