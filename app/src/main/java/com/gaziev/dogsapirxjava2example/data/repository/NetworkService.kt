package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.models.BoxersDogsData
import com.gaziev.dogsapirxjava2example.data.models.BreedRandomDogData
import com.gaziev.dogsapirxjava2example.data.models.RandomDogData
import io.reactivex.Single

interface NetworkService {

    fun getRandomDog(): Single<RandomDogData>
    fun getBreedRandomDog(): Single<BreedRandomDogData>
    fun getBoxerDogs(): Single<BoxersDogsData>
}