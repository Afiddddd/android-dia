package com.example.tugasandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.tugasandroid.R
import com.example.tugasandroid.databinding.ActivityMenuBinding
import com.example.tugasandroid.fragment.ApplicationFragment
import com.example.tugasandroid.fragment.HomeFragment
import com.example.tugasandroid.fragment.ProfileFragment

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentt: Fragment = HomeFragment()
        val transactionn: FragmentTransaction = supportFragmentManager.beginTransaction()
        transactionn.replace(R.id.content, fragmentt).commit()
        binding.navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> {
                    val fragment: Fragment = HomeFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content, fragment).commit()
                    true
                }

                R.id.menuApplication -> {
                    val fragment: Fragment = ApplicationFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content, fragment).commit()
                    true
                }

                R.id.menuProfile -> {
                    val fragment: Fragment = ProfileFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content,fragment).commit()
                    true
                }
                else -> false
            }
        }
    }
}