package com.example.travelwithme.MODALCLASS

import android.net.Uri

class ModalClass {


    var name: String = ""
    var location: String = ""
    var description: String = ""
    var price: String = ""
    var key: String = ""
    var ImageUri: String = ""

    var Rate : String = ""
    var Day : String = ""


    constructor() {

    }

    constructor(
        name: String,
        location: String,
        description: String,
        price: String,
        key: String,
        ImageUri: Uri,
        Rate: String,
        Day: String
    )
    {
        this.key = key
        this.name = name
        this.Rate = Rate
        this.Day = Day.toString()
        this.location = location
        this.description = description
        this.ImageUri = ImageUri.toString()
        this.price = price

    }
}