package com.example.travelwithme.ACTIVITY

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.travelwithme.MODALCLASS.ModalClass
import com.example.travelwithme.databinding.ActivityHikingDataBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class HikingDataActivity : AppCompatActivity() {


    private val PICK_IMAGE_REQUEST = 100
    lateinit var uri: Uri
    lateinit var ImageUri: Uri

    lateinit var  binding : ActivityHikingDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHikingDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }



    private fun initView() {

        var reference = FirebaseDatabase.getInstance().reference



        binding.btnUplodImage.setOnClickListener {


            val intent = Intent()
            intent.type = "Hikingimages/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(
                    intent,
                    "Select Image from here..."
                ),
                PICK_IMAGE_REQUEST
            )

        }


        binding.btnSumbit.setOnClickListener {


            var name = binding.edtPlaceName.text.toString()
            var location = binding.edtLocation.text.toString()
            var Description = binding.edtDescription.text.toString()
            var Distance = binding.edtDistance.text.toString()
            var price = binding.edtPrice.text.toString()
            var Day = binding.edtDay.text.toString()
            var rate = binding.edtRating.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Please Enter Your Place Name :", Toast.LENGTH_SHORT).show()
            } else if (location.isEmpty()) {
                Toast.makeText(this, "Please Enter Your location ", Toast.LENGTH_SHORT).show()
            } else if (Description.isEmpty()) {
                Toast.makeText(this, "Please Enter Your Description", Toast.LENGTH_SHORT).show()
            }
            else if (Distance.isEmpty()) {
                Toast.makeText(this, "Please Enter Your Distance", Toast.LENGTH_SHORT).show()
            }

            else if (price.isEmpty()) {
                Toast.makeText(this, "Please Enter Your price", Toast.LENGTH_SHORT).show()
            }

            else if (Day.isEmpty()) {
                Toast.makeText(this, "Please Enter Your Day", Toast.LENGTH_SHORT).show()
            }

            else if (rate.isEmpty()) {
                Toast.makeText(this, "Please Enter Your Rating", Toast.LENGTH_SHORT).show()
            }
            else {
                var key = reference.root.child("HikingTable").push().key ?: ""

                var modelclass = ModalClass(name, location, Description, price , key,ImageUri , rate, Day )

                reference.root.child("HikingTable").child(key).setValue(modelclass)
                    .addOnCompleteListener {

                        if (it.isSuccessful) {
                            Toast.makeText(this, "Data Added SuccessFully", Toast.LENGTH_SHORT)
                                .show()

//                            var i = Intent(this@AdminActivity, ShowDataAvtivity::class.java)
//                            startActivity(i)
                        }
                    }.addOnFailureListener {

                        Log.e("TAG", "Error: " + it)
                    }


            }

        }


    }



    fun uploadImage() {
        if (uri != null) {

            // Code for showing progressDialog while uploading
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            // Defining the child of storageReference
            val ref: StorageReference = FirebaseStorage.getInstance().getReference()
                .child("images/"+ UUID.randomUUID().toString())

            // adding listeners on upload
            // or failure of image
            if (ref != null) {
                ref.putFile(uri).continueWith{

                    ref.downloadUrl.addOnCompleteListener {
                        ImageUri=it.result
                    }


                }

                    .addOnSuccessListener { // Image uploaded successfully
                        // Dismiss dialog
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@HikingDataActivity,
                                "Image Uploaded!!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .addOnFailureListener { e -> // Error, Image not uploaded
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@HikingDataActivity,
                                "Failed " + e.message,
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }

            }
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {

            // Get the Uri of data
            uri = data.data!!
            uploadImage()

        }
    }
}