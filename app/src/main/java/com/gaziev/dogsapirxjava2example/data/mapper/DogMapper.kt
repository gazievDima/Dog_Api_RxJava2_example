package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.ui.models.DogDetails

class DogMapper : IMapper<DogEntity, DogDetails> {

    override fun map(t: DogEntity): DogDetails {
        return DogDetails(t.randomDog, t.status)
    }
}