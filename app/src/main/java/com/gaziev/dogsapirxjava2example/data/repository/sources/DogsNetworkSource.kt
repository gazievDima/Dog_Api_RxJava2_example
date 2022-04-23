package com.gaziev.dogsapirxjava2example.data.repository.sources

import com.gaziev.dogsapirxjava2example.data.models.DogsApiEntity
import com.gaziev.dogsapirxjava2example.data.models.DogApiEntity
import io.reactivex.Observable

interface DogsNetworkSource {

    fun getAny(): Observable<DogApiEntity>
    fun getCorgi(): Observable<DogApiEntity>
    fun getListCorgi(): Observable<DogsApiEntity>
}