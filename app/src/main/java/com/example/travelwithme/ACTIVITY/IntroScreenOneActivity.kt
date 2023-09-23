package com.example.travelwithme.ACTIVITY

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelwithme.databinding.ActivityIntroScreenOneBinding

class IntroScreenOneActivity : AppCompatActivity() {

    lateinit var binding: ActivityIntroScreenOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroScreenOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {


        binding.btnNext.setOnClickListener {

            val i = Intent(this@IntroScreenOneActivity, IntroScreenSecondActivity::class.java)
            startActivity(i)
        }
        binding.btnSkip.setOnClickListener {
            val i = Intent(this@IntroScreenOneActivity, CreateAccountActivity::class.java)
            startActivity(i)

        }
    }
}