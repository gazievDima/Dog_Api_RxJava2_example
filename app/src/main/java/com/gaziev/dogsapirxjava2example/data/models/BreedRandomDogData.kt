package com.gaziev.dogsapirxjava2example.data.models


/**
 *
 * {"message":"https:\/\/images.dog.ceo\/breeds\/akita\/512px-Akita_inu.jpeg","status":"success"}
 */

//https://dog.ceo/api/breed/Akita/images/random

class BreedRandomDogData(
    val randomDog: String?,
    val status: String?
) {
}