package com.example.travelwithme.FRAGEMENT

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelwithme.ACTIVITY.AllDataDisplayActivity
import com.example.travelwithme.ACTIVITY.BeachShowActivity
import com.example.travelwithme.ADAPTER.ShowAdpter
import com.example.travelwithme.MODALCLASS.ModalClass
import com.example.travelwithme.databinding.FragmentHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//         Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val View = binding.root
        var reference = FirebaseDatabase.getInstance().reference
        var list = ArrayList<ModalClass>()

        val progressDialog = ProgressDialog(context)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("AdminTable").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: ModalClass? = child.getValue(ModalClass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }

                progressDialog.dismiss()

                var adapter = ShowAdpter(
                    this@HomeFragment,
                    list,
                    onItemClick = { key, name, description,  price,ImageUri, location , rate , day ->

                        val i = Intent(
                            requireActivity().application,
                            AllDataDisplayActivity::class.java
                        )
                        i.putExtra("ImageUri", ImageUri)
                        i.putExtra("name", name)
                        i.putExtra("Rate",rate)
                        i.putExtra("Day",day)
                        i.putExtra("description", description)
                        i.putExtra("price", price)
                        i.putExtra("location", location)
                        startActivity(i)

                    })
                var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                adapter.refresh(list)
                binding.rcv.layoutManager = manager
                binding.rcv.adapter = adapter
                initview()

            }

            override fun onCancelled(error: DatabaseError) {

            }


        })

        return View
    }


    private fun initview() {


        binding.CardViewBeach.setOnClickListener {
//            Toast.makeText(requireContext(), "select", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireActivity().application, BeachShowActivity::class.java)
            intent.putExtra("Category", "Beach")
            startActivity(intent)
        }

        binding.CardViewHillsStations.setOnClickListener {

            val intent = Intent(requireActivity().application, BeachShowActivity::class.java)
            intent.putExtra("Category", "Hills")
            startActivity(intent)
        }

        binding.CardViewForest.setOnClickListener {

            val intent = Intent(requireActivity().application, BeachShowActivity::class.java)
            intent.putExtra("Category", "Forest")
            startActivity(intent)
        }

        binding.CardViewDesert.setOnClickListener {

            val intent = Intent(requireActivity().application, BeachShowActivity::class.java)
            intent.putExtra("Category", "Desert")
            startActivity(intent)

        }
        binding.CardViewHiking.setOnClickListener {

            val intent = Intent(requireActivity().application, BeachShowActivity::class.java)
            intent.putExtra("Category", "Hiking")
            startActivity(intent)
        }

    }


}
