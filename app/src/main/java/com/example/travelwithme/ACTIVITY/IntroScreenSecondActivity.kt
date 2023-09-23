package com.example.travelwithme.ACTIVITY

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelwithme.databinding.ActivityIntroScreenSecondBinding

class IntroScreenSecondActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroScreenSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroScreenSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        binding.btnNext.setOnClickListener {

            val i = Intent(this@IntroScreenSecondActivity, IntroScreenThreeActivity::class.java)
            startActivity(i)
        }
    }
}