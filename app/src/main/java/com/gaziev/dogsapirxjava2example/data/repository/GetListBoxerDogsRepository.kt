package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.FromData
import com.gaziev.dogsapirxjava2example.ui.models.BoxersDogs
import com.gaziev.dogsapirxjava2example.ui.screens.dogs.GetListBoxerDogs
import io.reactivex.Single

class GetListBoxerDogsRepository(
    private val service: NetworkService
) : GetListBoxerDogs {

    override fun execute(): Single<BoxersDogs> {
       return FromData().map(service.getBoxerDogs())
    }
}