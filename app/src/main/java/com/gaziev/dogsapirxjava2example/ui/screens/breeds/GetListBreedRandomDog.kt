package com.gaziev.dogsapirxjava2example.ui.screens.breeds

import com.gaziev.dogsapirxjava2example.ui.models.BreedRandomDog
import io.reactivex.Single

interface GetListBreedRandomDog {
    fun execute(): Single<BreedRandomDog>
}