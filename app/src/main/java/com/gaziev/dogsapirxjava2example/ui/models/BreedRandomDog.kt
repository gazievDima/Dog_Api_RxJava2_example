package com.gaziev.dogsapirxjava2example.ui.models


/**
 *
 * {"message":"https:\/\/images.dog.ceo\/breeds\/akita\/512px-Akita_inu.jpeg","status":"success"}
 */

//https://dog.ceo/api/breed/Akita/images/random

class BreedRandomDog(
    val randomDog: String?,
    val status: String?
) {
}