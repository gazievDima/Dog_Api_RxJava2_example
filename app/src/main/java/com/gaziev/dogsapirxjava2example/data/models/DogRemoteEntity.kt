package com.gaziev.dogsapirxjava2example.data.models

import com.google.gson.annotations.SerializedName

class DogRemoteEntity(
    @SerializedName("message")
    val imageUrl: String?,
    @SerializedName("status")
    val status: String?
)