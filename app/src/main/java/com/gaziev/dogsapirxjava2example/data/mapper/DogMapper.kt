package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogDetails
import javax.inject.Inject

class DogMapper @Inject constructor() : IMapper<DogEntity, DogDetails> {

    override fun map(t: DogEntity): DogDetails {
        return DogDetails(t.imageUrl, t.status)
    }
}