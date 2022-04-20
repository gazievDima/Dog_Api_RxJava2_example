package com.gaziev.dogsapirxjava2example.data.models

import com.google.gson.annotations.SerializedName

class BreedDogEntity(
    @SerializedName("message")
    val randomDog: String?,
    @SerializedName("status")
    val status: String?
) {
}