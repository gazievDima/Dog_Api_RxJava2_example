package com.gaziev.dogsapirxjava2example.presentation.screens.breed

import com.gaziev.dogsapirxjava2example.presentation.models.BreedDogDetails
import io.reactivex.Observable

interface IGetListBreedRandomDogsRepository {
    fun execute(): Observable<BreedDogDetails>
}