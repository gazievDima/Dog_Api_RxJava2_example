package com.gaziev.dogsapirxjava2example.ui.screens.breed

import com.gaziev.dogsapirxjava2example.ui.models.BreedDogDetails
import io.reactivex.Observable

interface IGetListBreedRandomDogsRepository {
    fun execute(): Observable<BreedDogDetails>
}