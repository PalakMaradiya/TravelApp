package com.example.travelwithme.FRAGEMENT

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelwithme.ACTIVITY.AdminActivity
import com.example.travelwithme.ACTIVITY.BeachDataActivity
import com.example.travelwithme.ACTIVITY.DesertDataActivity
import com.example.travelwithme.ACTIVITY.ForestDataActivity
import com.example.travelwithme.ACTIVITY.HikingDataActivity
import com.example.travelwithme.ACTIVITY.HillsDataActivity
import com.example.travelwithme.R
import com.example.travelwithme.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {


    private var _binding : FragmentProfileBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        val View = binding.root


        initview()


        return View
    }

    private fun initview() {


        binding.cardViewAdmin.setOnClickListener {
            val intent = Intent(getActivity(),AdminActivity::class.java)
            getActivity()?.startActivity(intent)
        }

        binding.cardViewBeach.setOnClickListener {
            val intent = Intent(getActivity(),BeachDataActivity::class.java)
            getActivity()?.startActivity(intent)

        }

        binding.cardViewHills.setOnClickListener {
            val intent = Intent(getActivity(),HillsDataActivity::class.java)
            getActivity()?.startActivity(intent)
        }

        binding.cardViewForest.setOnClickListener {
            val intent = Intent(getActivity(),ForestDataActivity::class.java)
            getActivity()?.startActivity(intent)
        }

        binding.cardViewDesert.setOnClickListener {

            val intent = Intent(getActivity(),DesertDataActivity::class.java)
            getActivity()?.startActivity(intent)
        }

        binding.cardViewHiking.setOnClickListener {

            val intent = Intent(getActivity(),HikingDataActivity::class.java)
            getActivity()?.startActivity(intent)

        }
    }

}