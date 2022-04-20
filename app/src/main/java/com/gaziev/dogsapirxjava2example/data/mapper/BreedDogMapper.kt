package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.ui.models.BreedDogDetails

class BreedDogMapper : IMapper<BreedDogEntity, BreedDogDetails> {

    override fun map(t: BreedDogEntity): BreedDogDetails {
        return BreedDogDetails(t.randomDog, t.status)
    }
}