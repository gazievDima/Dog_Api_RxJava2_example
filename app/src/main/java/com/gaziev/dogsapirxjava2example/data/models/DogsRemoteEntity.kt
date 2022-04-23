package com.gaziev.dogsapirxjava2example.data.models

import com.google.gson.annotations.SerializedName

class DogsRemoteEntity(
    @SerializedName("message")
    val listImageUrl: List<String?>?,
    @SerializedName("status")
    val status: String?
    )