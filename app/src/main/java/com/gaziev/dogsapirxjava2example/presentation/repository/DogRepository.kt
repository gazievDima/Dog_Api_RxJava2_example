package com.gaziev.dogsapirxjava2example.presentation.repository

import com.gaziev.dogsapirxjava2example.presentation.models.DogApiDetails
import io.reactivex.Observable

interface DogRepository {
    fun getCorgi(): Observable<DogApiDetails>
    fun getAny(): Observable<DogApiDetails>
}