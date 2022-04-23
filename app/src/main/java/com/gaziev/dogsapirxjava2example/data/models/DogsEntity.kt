package com.gaziev.dogsapirxjava2example.data.models

import com.google.gson.annotations.SerializedName

class DogsEntity(
    @SerializedName("message")
    val corgiDogs: List<String?>?,
    @SerializedName("status")
    val status: String?
    )