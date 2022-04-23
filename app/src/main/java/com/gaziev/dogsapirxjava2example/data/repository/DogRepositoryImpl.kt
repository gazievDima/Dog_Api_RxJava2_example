package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogApiEntity
import com.gaziev.dogsapirxjava2example.data.repository.sources.DogsNetworkSource
import com.gaziev.dogsapirxjava2example.presentation.models.DogApiDetails
import com.gaziev.dogsapirxjava2example.presentation.repository.DogRepository
import io.reactivex.Observable

class DogRepositoryImpl(
    private val service: DogsNetworkSource,
    private val mapper: IMapper<DogApiEntity, DogApiDetails>
) : DogRepository {

    override fun getCorgi(): Observable<DogApiDetails> {
        return service.getCorgi()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }

    override fun getAny(): Observable<DogApiDetails> {
        return service.getAny()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}