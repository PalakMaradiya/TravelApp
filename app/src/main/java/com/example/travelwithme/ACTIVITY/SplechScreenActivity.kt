package com.example.travelwithme.ACTIVITY

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.travelwithme.databinding.ActivitySplechScreenBinding

class SplechScreenActivity : AppCompatActivity() {
    lateinit var binding : ActivitySplechScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplechScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        Handler().postDelayed(
            {
                val i = Intent(this@SplechScreenActivity, IntroScreenOneActivity::class.java)
                startActivity(i)
                finish()
            }, 2000)
    }
}