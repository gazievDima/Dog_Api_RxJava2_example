package com.gaziev.dogsapirxjava2example.presentation.repository

import com.gaziev.dogsapirxjava2example.presentation.models.DogRemoteDetails
import io.reactivex.Observable

interface DogRepository {
    fun getCorgi(): Observable<DogRemoteDetails>
    fun getAny(): Observable<DogRemoteDetails>
}