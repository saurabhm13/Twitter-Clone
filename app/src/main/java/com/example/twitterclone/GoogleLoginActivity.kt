package com.example.twitterclone

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.twitterclone.Features.Auth.ui.LoginActivity
import com.example.twitterclone.Features.Auth.ui.SignupActivity

class GoogleLoginActivity : AppCompatActivity() {

    lateinit var btn_continueWithGoogle: Button
    lateinit var btn_CreateAccount: Button
    lateinit var CWG_login_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_login)

        initData()

        btn_CreateAccount.setOnClickListener(View.OnClickListener {
            val inToSignupActivity = Intent(this, SignupActivity::class.java)
            startActivity(inToSignupActivity)
        })

        CWG_login_btn.setOnClickListener(View.OnClickListener {
            val inToLoginActivity = Intent(this, LoginActivity::class.java)
            startActivity(inToLoginActivity)
        })
    }

    fun initData(){
        CWG_login_btn = findViewById(R.id.CWG_login_btn)
        btn_CreateAccount = findViewById(R.id.btn_create_account)
        btn_continueWithGoogle = findViewById(R.id.btn_continueWithGoogle)
    }
}