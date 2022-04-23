package com.gaziev.dogsapirxjava2example.data.repository.sources

import com.gaziev.dogsapirxjava2example.data.models.DogsEntity
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import io.reactivex.Observable

interface DogsNetworkSource {

    fun getAny(): Observable<DogEntity>
    fun getCorgi(): Observable<DogEntity>
    fun getListCorgi(): Observable<DogsEntity>
}