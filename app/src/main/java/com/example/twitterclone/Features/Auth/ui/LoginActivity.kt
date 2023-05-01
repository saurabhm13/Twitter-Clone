package com.example.twitterclone.Features.Auth.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.twitterclone.GoogleLoginActivity
import com.example.twitterclone.MainActivity
import com.example.twitterclone.R
import com.example.twitterclone.util.toast
import com.google.android.material.textfield.TextInputLayout
import io.appwrite.Client
import io.appwrite.services.Account
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var login_email: TextInputLayout
    private lateinit var login_password: TextInputLayout
    private lateinit var login_button: Button
    private lateinit var login_forgotPassBtn: Button

    lateinit var clearLoginTobBar: ImageView

    lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initData()

        clearLoginTobBar.setOnClickListener(View.OnClickListener {
            val inToGoogleLogin = Intent(this@LoginActivity, GoogleLoginActivity::class.java)
            startActivity(inToGoogleLogin)
        })

        client = Client(this@LoginActivity)
            .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
            .setProject("644c98017d02ad5e6556")
            .setSelfSigned(status = true)

        login_button.setOnClickListener(View.OnClickListener {
            performLogin()
        })

    }

    fun performLogin() {
        val email = login_email.editText?.text.toString()
        val password = login_password.editText?.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            toast("Provide valid email and password")
        }

        val account = Account(client)

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val session = account.createEmailSession(
                    email = email,
                    password = password
                )
                toast("Login Successful")

                val inToMain = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(inToMain)
                finishAffinity()
                // Do something with the user object here
            } catch (e: Exception) {
                // Handle any exceptions here
                toast("$e")
                android.util.Log.d("MainActivity", "Exception $e")
            }
        }

    }

    private fun initData() {
        login_email = findViewById(R.id.email_login)
        login_password = findViewById(R.id.password_login)

        login_button = findViewById(R.id.btn_login)
        login_forgotPassBtn = findViewById(R.id.btn_forgotPassword_login)
        clearLoginTobBar = findViewById(R.id.clear_login_topBar)
    }
}