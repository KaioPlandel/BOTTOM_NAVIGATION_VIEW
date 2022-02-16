package com.plandel.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.plandel.bottomnavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var homeFragment: HomeFragment
    lateinit var messageFragment: MessageFragment
    lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        homeFragment = HomeFragment()
        messageFragment = MessageFragment()
        profileFragment = ProfileFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameMenu, messageFragment)
                .commit()
        }

        var badgeMessage = binding.bottomNavigation.getOrCreateBadge(R.id.menuMessages)
        badgeMessage.isVisible = true
        badgeMessage.number = 32

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> openHomeFragment()
                R.id.menuMessages -> openMessageFragment()
                R.id.menuProfile -> openProfileFragment()
                else -> Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    fun openHomeFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameMenu, homeFragment)
                .commit()
        }
    }

    fun openMessageFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameMenu, messageFragment)
                .commit()
        }
    }

    fun openProfileFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameMenu, profileFragment)
                .commit()
        }
    }
}