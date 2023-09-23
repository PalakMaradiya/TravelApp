package com.example.travelwithme.ACTIVITY

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelwithme.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        binding.imgBack.setOnClickListener {

            onBackPressed()
        }
        binding.txtSignUp.setOnClickListener {

            val i = Intent(this@LogInActivity, SigninActivity::class.java)
            startActivity(i)
        }
        binding.btnLogin.setOnClickListener {

            val i = Intent(this@LogInActivity, DashBordActivity::class.java)
            startActivity(i)
        }

    }
}