package com.gaziev.dogsapirxjava2example.presentation.repository

import com.gaziev.dogsapirxjava2example.presentation.models.DogDetails
import io.reactivex.Observable

interface DogRepository {
    fun getCorgi(): Observable<DogDetails>
    fun getAny(): Observable<DogDetails>
}