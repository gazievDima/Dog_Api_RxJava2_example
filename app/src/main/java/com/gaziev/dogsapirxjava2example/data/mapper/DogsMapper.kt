package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.DogsApiEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogsApiDetails
import javax.inject.Inject

class DogsMapper @Inject constructor() : IMapper<DogsApiEntity, DogsApiDetails> {

    override fun map(t: DogsApiEntity): DogsApiDetails {
        return DogsApiDetails(t.listImageUrl, t.status)
    }
}