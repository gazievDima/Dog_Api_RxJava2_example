package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.data.repository.sources.DogsNetworkSource
import com.gaziev.dogsapirxjava2example.presentation.models.DogDetails
import com.gaziev.dogsapirxjava2example.presentation.repository.DogRepository
import io.reactivex.Observable

class DogRepositoryImpl(
    private val service: DogsNetworkSource,
    private val mapper: IMapper<DogEntity, DogDetails>
) : DogRepository {

    override fun getCorgi(): Observable<DogDetails> {
        return service.getCorgi()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }

    override fun getAny(): Observable<DogDetails> {
        return service.getAny()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}