package com.musicpoint

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.musicpoint.data.ASSharedPreferences
import com.musicpoint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPrefs: ASSharedPreferences

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        sharedPrefs = ASSharedPreferences(context)
        return super.onCreateView(name, context, attrs)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        binding.btAccess.setOnClickListener {
            val username = binding.tvUsername.text.toString()
            sharedPrefs.updateUsername(username)

            Log.i("username", sharedPrefs.getUsername().toString())

            val intent = Intent(this@MainActivity, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}