package com.masdika.latihanfirebase.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.masdika.latihanfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")
        val idToken = intent.getStringExtra("id token")

        binding.accountEmail.text = email
        binding.accountName.text = displayName
        binding.accountIdToken.text = idToken

        // Inisiasi Menu Fragment
        //supportFragmentManager.beginTransaction().replace(R.id.frame_ly, ProfileFragment()).commit()

//        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
//            override fun onTabSelected(
//                lastIndex: Int,
//                lastTab: AnimatedBottomBar.Tab?,
//                newIndex: Int,
//                newTab: AnimatedBottomBar.Tab
//            ) {
//                Log.d("Bottom_Bar", "Selected index: $newIndex, title: ${newTab.title}")
//                when (newTab.id) {
//                    // Get ID from nav_menu
//                    R.id.tab_home -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.frame_ly, ProfileFragment()).commit()
//                    }
//                    R.id.tab_insert -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.frame_ly, InsertDataFragment()).commit()
//                    }
//                    R.id.tab_view -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.frame_ly, ViewDataFragment()).commit()
//                    }
//                }
//            }
//        })
    }
}