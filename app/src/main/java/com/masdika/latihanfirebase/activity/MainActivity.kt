package com.masdika.latihanfirebase.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.masdika.latihanfirebase.R
import com.masdika.latihanfirebase.databinding.ActivityMainBinding
import com.masdika.latihanfirebase.fragment.InsertDataFragment
import com.masdika.latihanfirebase.fragment.ProfileFragment
import com.masdika.latihanfirebase.fragment.ViewDataFragment
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")
        val googleProfileImageURL = intent.getStringExtra("image_profile")

        //Inisiasi Menu Fragment and Add bundle to pass data
        val bundle = Bundle()
        bundle.putString("display_name", displayName)
        bundle.putString("email", email)
        bundle.putString("profile_image", googleProfileImageURL)
        val fragment = ProfileFragment()
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.frame_ly, fragment).commit()
        //supportFragmentManager.beginTransaction().replace(R.id.frame_ly, ProfileFragment()).commit()

        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                Log.d("Bottom_Bar", "Selected index: $newIndex, title: ${newTab.title}")
                when (newTab.id) {
                    // Get ID from nav_menu
                    R.id.tab_home -> {
                        val fragment = ProfileFragment()
                        fragment.arguments = bundle
                        supportFragmentManager.beginTransaction().replace(R.id.frame_ly, fragment)
                            .commit()
                    }
                    R.id.tab_insert -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_ly, InsertDataFragment()).commit()
                    }
                    R.id.tab_view -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_ly, ViewDataFragment()).commit()
                    }
                }
            }
        })
    }
}