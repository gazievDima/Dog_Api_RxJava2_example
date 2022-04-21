package com.gaziev.dogsapirxjava2example.presentation.screens.random

import com.gaziev.dogsapirxjava2example.presentation.models.DogDetails
import io.reactivex.Observable

interface IGetRandomDogRepository {
    fun execute(): Observable<DogDetails>
}