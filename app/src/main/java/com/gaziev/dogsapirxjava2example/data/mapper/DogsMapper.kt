package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.DogsRemoteEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogsRemoteDetails
import javax.inject.Inject

class DogsMapper @Inject constructor() : IMapper<DogsRemoteEntity, DogsRemoteDetails> {

    override fun map(t: DogsRemoteEntity): DogsRemoteDetails {
        return DogsRemoteDetails(t.listImageUrl, t.status)
    }
}