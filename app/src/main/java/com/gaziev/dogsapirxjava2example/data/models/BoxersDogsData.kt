package com.gaziev.dogsapirxjava2example.data.models

/**
 * {
"message": [
"https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg",
"https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg",
"https://images.dog.ceo/breeds/hound-afghan/n02088094_1023.jpg",
],
"status": "success"
}
 */

//https://dog.ceo/api/breed/hound/images

class BoxersDogsData(
    val boxerDogs: List<String>?,
    val status: String?
    )