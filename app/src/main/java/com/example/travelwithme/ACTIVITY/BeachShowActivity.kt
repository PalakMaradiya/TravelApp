package com.example.travelwithme.ACTIVITY

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelwithme.ADAPTER.BeachAdapter
import com.example.travelwithme.ADAPTER.ShowAdpter
import com.example.travelwithme.MODALCLASS.ModalClass
import com.example.travelwithme.databinding.ActivityBeachShowBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BeachShowActivity : AppCompatActivity() {

    lateinit var PlaceName: String
    lateinit var binding: ActivityBeachShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeachShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

        var list = ArrayList<ModalClass>()


        if (intent != null) {

            PlaceName = intent.getStringExtra("Category").toString()
            binding.txtTitle.text = PlaceName
            Log.e("TAG", "Name: " + PlaceName)


        }


        if (PlaceName == "Beach") {

            var reference = FirebaseDatabase.getInstance().reference
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

                    var adapter = BeachAdapter(
                        this@BeachShowActivity,
                        list,
                        onItemClick = { key, name, description, price, ImageUri, location ,Rate , Day->

                            val i =
                                Intent(this@BeachShowActivity, AllDataDisplayActivity::class.java)
                            i.putExtra("ImageUri", ImageUri)
                            Log.e("TAG", "Click: " + ImageUri)

                            i.putExtra("title", PlaceName)
                            i.putExtra("name", name)
                            i.putExtra("description", description)
                            i.putExtra("price", price)
                            i.putExtra("Rate",Rate)
                            i.putExtra("Day", Day)
                            i.putExtra("location", location)
                            startActivity(i)

                        })
                    var manager = LinearLayoutManager(
                        this@BeachShowActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter.refresh(list)
                    binding.rcv.layoutManager = manager
                    binding.rcv.adapter = adapter


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }
        if (PlaceName == "Desert") {

            var reference = FirebaseDatabase.getInstance().reference
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

                    var adapter = BeachAdapter(
                        this@BeachShowActivity,
                        list,
                        onItemClick = { key, name, description, price, ImageUri, location ,Rate , Day->

                            val i =
                                Intent(this@BeachShowActivity, AllDataDisplayActivity::class.java)
                            i.putExtra("ImageUri", ImageUri)
                            Log.e("TAG", "Click: " + ImageUri)

                            i.putExtra("title", PlaceName)
                            i.putExtra("name", name)
                            i.putExtra("description", description)
                            i.putExtra("price", price)
                            i.putExtra("Rate",Rate)
                            i.putExtra("Day", Day)
                            i.putExtra("location", location)
                            startActivity(i)

                        })
                    var manager = LinearLayoutManager(
                        this@BeachShowActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter.refresh(list)
                    binding.rcv.layoutManager = manager
                    binding.rcv.adapter = adapter


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }


        if (PlaceName == "Hills") {


            var reference = FirebaseDatabase.getInstance().reference
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
                    var adapter = BeachAdapter(
                        this@BeachShowActivity,
                        list,
                        onItemClick = { key, name, description, price, ImageUri, location  ,Rate , Day ->

                            val i =
                                Intent(this@BeachShowActivity, AllDataDisplayActivity::class.java)
                            i.putExtra("title", PlaceName)
                            i.putExtra("ImageUri", ImageUri)
                            i.putExtra("name", name)
                            i.putExtra("description", description)
                            i.putExtra("price", price)
                            i.putExtra("Rate",Rate)
                            i.putExtra("Day", Day)
                            i.putExtra("location", location)
                            startActivity(i)

                        })
                    var manager = LinearLayoutManager(
                        this@BeachShowActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter.refresh(list)
                    binding.rcv.layoutManager = manager
                    binding.rcv.adapter = adapter

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }

        if (PlaceName == "Forest") {

            var reference = FirebaseDatabase.getInstance().reference
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


                    var adapter = BeachAdapter(
                        this@BeachShowActivity,
                        list,
                        onItemClick = { key, name, description, price, ImageUri, location ,Rate , Day ->

                            val i =
                                Intent(this@BeachShowActivity, AllDataDisplayActivity::class.java)
                            i.putExtra("title", PlaceName)
                            i.putExtra("name", name)
                            i.putExtra("ImageUri", ImageUri)
                            i.putExtra("description", description)
                            i.putExtra("price", price)
                            i.putExtra("Rate",Rate)
                            i.putExtra("Day", Day)
                            i.putExtra("location", location)
                            startActivity(i)

                        })
                    var manager = LinearLayoutManager(
                        this@BeachShowActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter.refresh(list)
                    binding.rcv.layoutManager = manager
                    binding.rcv.adapter = adapter

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
            var reference = FirebaseDatabase.getInstance().reference
            reference.root.child("HikingTable").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (child in snapshot.children) {
                        var data: ModalClass? = child.getValue(ModalClass::class.java)
                        if (data != null) {
                            list.add(data)
                        }
                    }

                    progressDialog.dismiss()

                    var adapter = BeachAdapter(
                        this@BeachShowActivity,
                        list,
                        onItemClick = {key, name, description,  price, ImageUri,location , Rate , Day ->

                            val i =
                                Intent(this@BeachShowActivity, AllDataDisplayActivity::class.java)
                            i.putExtra("title", PlaceName)
                            i.putExtra("ImageUri", ImageUri)
                            i.putExtra("name", name)
                            i.putExtra("description", description)
                            i.putExtra("price", price)
                            i.putExtra("Rate",Rate)
                            i.putExtra("Day", Day)
                            i.putExtra("location", location)
                            startActivity(i)

                        })
                    var manager = LinearLayoutManager(
                        this@BeachShowActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter.refresh(list)
                    binding.rcv.layoutManager = manager
                    binding.rcv.adapter = adapter

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }




    }


}





