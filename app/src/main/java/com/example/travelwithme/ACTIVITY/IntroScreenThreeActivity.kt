package com.example.travelwithme.ACTIVITY

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelwithme.databinding.ActivityIntroScreenThreeBinding

class IntroScreenThreeActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroScreenThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroScreenThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.btnNext.setOnClickListener {

            val i = Intent(this@IntroScreenThreeActivity, CreateAccountActivity::class.java)
            startActivity(i)
        }
    }
}