package com.gaziev.dogsapirxjava2example.presentation.screens.breed

import com.gaziev.dogsapirxjava2example.presentation.models.BreedDogDetails
import dagger.Provides
import io.reactivex.Observable

interface IGetBreedRandomDogsRepository {
    fun execute(): Observable<BreedDogDetails>
}