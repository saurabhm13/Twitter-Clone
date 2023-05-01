package com.example.twitterclone.Features.Auth.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.twitterclone.GoogleLoginActivity
import com.example.twitterclone.MainActivity
import com.example.twitterclone.R
import com.example.twitterclone.util.toast
import com.google.android.material.textfield.TextInputLayout
import io.appwrite.Client
import io.appwrite.ID
import io.appwrite.services.Account
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    lateinit var signup_name: TextInputLayout
    lateinit var signup_email: TextInputLayout
    lateinit var signup_password: TextInputLayout
    lateinit var signup_button: Button

    lateinit var clearSignupTopBar: ImageView

    lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        initData()

        clearSignupTopBar.setOnClickListener(View.OnClickListener {
            val intoGoogleLogin = Intent(this@SignupActivity, GoogleLoginActivity::class.java)
            startActivity(intoGoogleLogin)
        })

        client = Client(this@SignupActivity)
            .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
            .setProject("644c98017d02ad5e6556")

        signup_button.setOnClickListener(View.OnClickListener {
            performSignup()
        })
    }

    private fun performSignup() {
        val name = signup_name.editText?.text.toString()
        val email = signup_email.editText?.text.toString()
        val password = signup_password.editText?.text.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
            toast("Provide valid data")
        }

        val account = Account(client)

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val user = account.create(
                    userId = ID.unique(),
                    email = email,
                    password = password
                )

                toast("Signup Successful")
                val intoHome = Intent(this@SignupActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intoHome)
                finishAffinity()

            }catch (e: Exception){
                toast("Signup failed! $e")
            }

        }

    }

    private fun initData() {
        signup_email = findViewById(R.id.signup_email)
        signup_name= findViewById(R.id.signup_name)
        signup_password = findViewById(R.id.signup_password)

        signup_button = findViewById(R.id.signup_button)
        clearSignupTopBar = findViewById(R.id.clear_signup_topBar)
    }
}