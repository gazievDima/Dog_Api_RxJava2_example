package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import io.reactivex.Observable
import io.reactivex.Single

interface INetworkDogService {

    fun getRandomDog(): Observable<DogEntity>
    fun getBreedRandomDog(): Observable<BreedDogEntity>
    fun getCorgiDogs(): Observable<CorgiDogsEntity>
}