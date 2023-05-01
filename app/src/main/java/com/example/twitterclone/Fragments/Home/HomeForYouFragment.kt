package com.example.twitterclone.Fragments.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.twitterclone.R
import io.appwrite.Client
import io.appwrite.ID
import io.appwrite.services.Account
import io.appwrite.services.Realtime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HomeForYouFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_for_you, container, false)

        // Get the context associated with the Fragment
        val context = requireContext()

        val client = Client(context)
            .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
            .setProject("644c98017d02ad5e6556")
            .setSelfSigned(status = true)

        val account = io.appwrite.services.Account(client)

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val user = account.create(
                    userId = ID.unique(),
                    email = "test@example.com",
                    password = "passqwert"
                )
                Toast.makeText(context, "User $user", Toast.LENGTH_LONG).show()

                // Do something with the user object here
            } catch (e: Exception) {
                // Handle any exceptions here
                Toast.makeText(context, "Exception $e", Toast.LENGTH_LONG).show()

                android.util.Log.d("MainActivity", "Exception $e")
            }
        }

        return view

    }

}