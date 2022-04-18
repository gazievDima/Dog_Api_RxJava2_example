package com.gaziev.dogsapirxjava2example.data.models

/**
 * {
"message": "https://images.dog.ceo/breeds/keeshond/n02112350_8572.jpg",
"status": "success"
}
 */

//https://dog.ceo/api/breeds/image/random

class RandomDogData(
    val randomDog: String?,
    val status: String?
)