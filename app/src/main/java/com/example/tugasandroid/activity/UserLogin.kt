package com.example.tugasandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasandroid.databinding.ActivityJobDetailsBinding
import com.example.tugasandroid.databinding.ActivityUserLoginBinding

class UserLogin : AppCompatActivity() {
    lateinit var binding: ActivityUserLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var id = intent.getStringExtra("id")
        var name = intent.getStringExtra("name")
        var email = intent.getStringExtra("email")
        binding.tvUserId.text = "UserId: $id"
        binding.tvUserName.text = "Username: $name"
        binding.tvUserEmail.text ="Email: $email"
    }
}