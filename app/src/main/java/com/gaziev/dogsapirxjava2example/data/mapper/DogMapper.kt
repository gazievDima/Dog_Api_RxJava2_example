package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.DogApiEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogApiDetails
import javax.inject.Inject

class DogMapper @Inject constructor() : IMapper<DogApiEntity, DogApiDetails> {

    override fun map(t: DogApiEntity): DogApiDetails {
        return DogApiDetails(t.imageUrl, t.status)
    }
}