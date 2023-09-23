package com.example.travelwithme.ACTIVITY

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelwithme.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {
    lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

    }
}