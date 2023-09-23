package com.example.travelwithme.ACTIVITY

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.travelwithme.MODALCLASS.ModalClass
import com.example.travelwithme.R
import com.example.travelwithme.databinding.ActivityAllDataDisplayBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllDataDisplayActivity : AppCompatActivity() {
    lateinit var PlaceName: String
    lateinit var binding: ActivityAllDataDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllDataDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun initView() {

        binding.imgBack.setOnClickListener {

            onBackPressed()
        }

        like()
        var list = ArrayList<ModalClass>()
        var reference = FirebaseDatabase.getInstance().reference


        if (intent != null) {
            var image = intent.getStringExtra("ImageUri")

            Log.e("TAG", "initView: " + image)
            Glide.with(baseContext).load(image).into(binding.imgBeach)

            PlaceName = intent.getStringExtra("title").toString()
            var location = intent.getStringExtra("location").toString()
            var Desceprition = intent.getStringExtra("description").toString()
            var name = intent.getStringExtra("name").toString()
            var rate = intent.getStringExtra("Rate").toString()
            binding.txtPlaceName.text = name
            binding.txtLocation.text = location
            binding.txtRate.text = rate
//            binding.txtTitle.text = PlaceName
            binding.txtDescripition.text = Desceprition
        }


        if (PlaceName == "Beach") {


            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Please Wait")
            progressDialog.setMessage("Application is loading, please wait")
            progressDialog.show()


            reference.root.child("BeachTable").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (child in snapshot.children) {
                        var data: ModalClass? = child.getValue(ModalClass::class.java)
                        if (data != null) {
                            list.add(data)
                        }
                    }

                    progressDialog.dismiss()


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        }

        if (PlaceName == "Hills") {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Please Wait")
            progressDialog.setMessage("Application is loading, please wait")
            progressDialog.show()


            reference.root.child("HillsTable").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (child in snapshot.children) {
                        var data: ModalClass? = child.getValue(ModalClass::class.java)
                        if (data != null) {
                            list.add(data)
                        }
                    }

                    progressDialog.dismiss()


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }

        if (PlaceName == "Forest") {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Please Wait")
            progressDialog.setMessage("Application is loading, please wait")
            progressDialog.show()


            reference.root.child("ForestTable").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (child in snapshot.children) {
                        var data: ModalClass? = child.getValue(ModalClass::class.java)
                        if (data != null) {
                            list.add(data)
                        }
                    }

                    progressDialog.dismiss()


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }



        if (PlaceName == "Hiking") {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Please Wait")
            progressDialog.setMessage("Application is loading, please wait")
            progressDialog.show()


            reference.root.child("HikingTable").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (child in snapshot.children) {
                        var data: ModalClass? = child.getValue(ModalClass::class.java)
                        if (data != null) {
                            list.add(data)
                        }
                    }

                    progressDialog.dismiss()


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }

        if(PlaceName == "Desert")
        {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Please Wait")
            progressDialog.setMessage("Application is loading, please wait")
            progressDialog.show()


            reference.root.child("DesertTable").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (child in snapshot.children) {
                        var data: ModalClass? = child.getValue(ModalClass::class.java)
                        if (data != null) {
                            list.add(data)
                        }
                    }

                    progressDialog.dismiss()


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        }

        else
        {

            val progressDialog = ProgressDialog(this)
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


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        }

    }

    private fun like() {
        binding.imgLike.setOnClickListener {

            binding.imgLike.setImageResource(R.drawable.fill)

        }
    }

}