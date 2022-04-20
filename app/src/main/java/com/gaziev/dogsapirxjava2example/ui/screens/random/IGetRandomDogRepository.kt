package com.gaziev.dogsapirxjava2example.ui.screens.random

import com.gaziev.dogsapirxjava2example.ui.models.DogDetails
import io.reactivex.Observable
import io.reactivex.Single

interface IGetRandomDogRepository {
    fun execute(): Observable<DogDetails>
}