package com.example.travelwithme.ACTIVITY

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelwithme.FRAGEMENT.HomeFragment
import com.example.travelwithme.FRAGEMENT.LikeFragment
import com.example.travelwithme.FRAGEMENT.MapFragment
import com.example.travelwithme.FRAGEMENT.ProfileFragment
import com.example.travelwithme.FRAGEMENT.SearchFragment
import com.example.travelwithme.R
import com.example.travelwithme.databinding.ActivityDashBordBinding

class DashBordActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashBordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    @SuppressLint("ResourceAsColor")
    private fun initview() {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, HomeFragment())
        transaction.commit()

        binding.btnHome.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, HomeFragment())
            transaction.commit()
        }


        binding.btnFavourite.setOnClickListener {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, LikeFragment())
            transaction.commit()
        }

        binding.btnSearch.setOnClickListener {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, SearchFragment())
            transaction.commit()

        }

        binding.btnMap.setOnClickListener {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, MapFragment())
            transaction.commit()


        }

        binding.btnProfile.setOnClickListener {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, ProfileFragment())
            transaction.commit()
        }


        binding.btnHome.setOnClickListener {

           binding.imgHome.setImageResource(R.drawable.fillhome)
        }

        binding.btnSearch.setOnClickListener {

//            binding.btnSearch.setBackgroundResource(R.drawable.fillsearch)

            binding.imgSearch.setImageResource(R.drawable.fillsearch)
        }
        binding.btnFavourite.setOnClickListener {

            binding.imgLike.setImageResource(R.drawable.blacklike)
        }

        binding.btnMap.setOnClickListener {

            binding.imgMap.setImageResource(R.drawable.fillpin)
        }

        binding.btnProfile.setOnClickListener {

            binding.imgProfile.setImageResource(R.drawable.fillprofile)
        }

    }
}