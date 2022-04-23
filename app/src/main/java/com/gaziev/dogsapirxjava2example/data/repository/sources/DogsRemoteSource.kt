package com.gaziev.dogsapirxjava2example.data.repository.sources

import com.gaziev.dogsapirxjava2example.data.models.DogsRemoteEntity
import com.gaziev.dogsapirxjava2example.data.models.DogRemoteEntity
import io.reactivex.Observable

interface DogsRemoteSource {

    fun getAny(): Observable<DogRemoteEntity>
    fun getCorgi(): Observable<DogRemoteEntity>
    fun getListCorgi(): Observable<DogsRemoteEntity>
}