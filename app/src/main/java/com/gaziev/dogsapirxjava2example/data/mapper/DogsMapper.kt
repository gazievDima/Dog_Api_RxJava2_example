package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.DogsEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogsDetails
import javax.inject.Inject

class DogsMapper @Inject constructor() : IMapper<DogsEntity, DogsDetails> {

    override fun map(t: DogsEntity): DogsDetails {
        return DogsDetails(t.corgiDogs, t.status)
    }
}