package com.example.travelwithme.ACTIVITY

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelwithme.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        binding.imgBack.setOnClickListener {

            onBackPressed()
        }

        binding.btnLogin.setOnClickListener {


            val i = Intent(this@CreateAccountActivity, LogInActivity::class.java)
            startActivity(i)
        }

        binding.btnSignin.setOnClickListener {

            val i = Intent(this@CreateAccountActivity, SigninActivity::class.java)
            startActivity(i)

        }

    }
}