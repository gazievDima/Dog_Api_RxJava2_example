package com.gaziev.dogsapirxjava2example.ui.screens.random

import com.gaziev.dogsapirxjava2example.ui.models.RandomDog
import io.reactivex.Observable
import io.reactivex.Single

interface GetRandomDog {
    fun execute(): Single<RandomDog>
}