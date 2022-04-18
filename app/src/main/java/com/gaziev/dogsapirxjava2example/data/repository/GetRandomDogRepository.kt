package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.FromData
import com.gaziev.dogsapirxjava2example.ui.models.RandomDog
import com.gaziev.dogsapirxjava2example.ui.screens.random.GetRandomDog
import io.reactivex.Observable
import io.reactivex.Single

class GetRandomDogRepository(
    private val service: NetworkService
) : GetRandomDog {

    override fun execute(): Single<RandomDog> {
        return FromData().map(service.getRandomDog())
    }
}