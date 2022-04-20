package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.ui.models.CorgiDogsDetails

class CorgiDogsMapper : IMapper<CorgiDogsEntity, CorgiDogsDetails> {

    override fun map(t: CorgiDogsEntity): CorgiDogsDetails {
        return CorgiDogsDetails(t.corgiDogs, t.status)
    }
}