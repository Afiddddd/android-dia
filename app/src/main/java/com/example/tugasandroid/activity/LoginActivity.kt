package com.example.tugasandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.tugasandroid.databinding.ActivityLoginBinding
import com.example.tugasandroid.databinding.ActivitySplashScreenBinding
import com.example.tugasandroid.model.requestlogin.RequestLogin
import com.example.tugasandroid.utils.PrefsKeys
import com.example.tugasandroid.viewmodel.JobViewModel
import com.example.tugasandroid.viewmodel.LoginViewModel
import com.pixplicity.easyprefs.library.Prefs

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener {
            viewModel.postLogin(RequestLogin(binding.etEmail.text.toString(),binding.etPassword.text.toString()))
        }
        setObserver()


//        binding.btnLogin.setOnClickListener {
//            val email = binding.etEmail.text.toString()
//            val password = binding.etPassword.text.toString()
//            Prefs.putString(PrefsKeys.USERNAME, email)
//            Prefs.putString(PrefsKeys.PASSWORD, password)
//            Prefs.putBoolean(PrefsKeys.IS_LOGIN, true)
//            val intent = Intent(this, MenuActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun setObserver() {
        viewModel.listResponse().observe(this, {
            var intent = Intent(this, UserLogin::class.java)
            intent.putExtra("id", it.data.userId)
            intent.putExtra("id", it.data.userName.toString())
            intent.putExtra("email", it.data.userEmail.toString())
            startActivity(intent)
        })
        viewModel.getIsError().observe(this, {
            if(it) {
                Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }


}