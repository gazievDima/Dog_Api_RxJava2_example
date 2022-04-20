package com.gaziev.dogsapirxjava2example.ui.screens.breeds

import com.gaziev.dogsapirxjava2example.ui.models.BreedDogDetails
import io.reactivex.Observable
import io.reactivex.Single

interface IGetListBreedRandomDogsRepository {
    fun execute(): Observable<BreedDogDetails>
}