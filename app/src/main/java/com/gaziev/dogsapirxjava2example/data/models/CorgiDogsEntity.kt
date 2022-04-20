package com.gaziev.dogsapirxjava2example.data.models

import com.google.gson.annotations.SerializedName

class CorgiDogsEntity(
    @SerializedName("message")
    val corgiDogs: List<String?>?,
    @SerializedName("status")
    val status: String?
    )