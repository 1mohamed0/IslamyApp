package com.devoma.islamiapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devoma.islamiapp.R
import com.devoma.islamiapp.databinding.ActivityMainBinding
import com.devoma.islamiapp.home.tabs.HadithTab.HadithFragment
import com.devoma.islamiapp.home.tabs.QuranTab.QuranFragment
import com.devoma.islamiapp.home.tabs.RadioTab.RadioFragment
import com.devoma.islamiapp.home.tabs.SebhaTab.SebhaFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the default fragment (QuranFragment)
        binding.bottomNavView.selectedItemId = R.id.naviToQuran
        showFragment(QuranFragment())

        // Handle BottomNavigationView item clicks
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            val fragment: Fragment
            when (menuItem.itemId) {
                R.id.naviToQuran -> {
                   showFragment(QuranFragment())
                    true
                }
                R.id.naviToHadeth -> {
                    showFragment(HadithFragment())
                    true
                }
                R.id.naviToSabha -> {
                    showFragment(SebhaFragment())
                    true
                }
                R.id.naviToRadio -> {
                    showFragment(RadioFragment())
                    true
                }else -> false

            }
        }
        showFragment(QuranFragment())
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmrnt_container, fragment)
            .commit()
    }
}