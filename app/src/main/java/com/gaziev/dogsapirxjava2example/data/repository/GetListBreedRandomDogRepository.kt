package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.FromData
import com.gaziev.dogsapirxjava2example.ui.models.BreedRandomDog
import com.gaziev.dogsapirxjava2example.ui.screens.breeds.GetListBreedRandomDog
import io.reactivex.Observable
import io.reactivex.Single

class GetListBreedRandomDogRepository(
    private val service: NetworkService
) : GetListBreedRandomDog {

    override fun execute(): Single<BreedRandomDog> {
        return FromData().map(service.getBreedRandomDog())
    }
}