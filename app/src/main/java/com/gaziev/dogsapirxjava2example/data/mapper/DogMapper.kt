package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.DogRemoteEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogRemoteDetails
import javax.inject.Inject

class DogMapper @Inject constructor() : IMapper<DogRemoteEntity, DogRemoteDetails> {

    override fun map(t: DogRemoteEntity): DogRemoteDetails {
        return DogRemoteDetails(t.imageUrl, t.status)
    }
}