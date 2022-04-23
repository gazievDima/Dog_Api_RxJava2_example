package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogsEntity
import com.gaziev.dogsapirxjava2example.data.repository.sources.DogsNetworkSource
import com.gaziev.dogsapirxjava2example.presentation.models.DogsDetails
import com.gaziev.dogsapirxjava2example.presentation.repository.DogsRepository
import io.reactivex.Observable
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(
    private val service: DogsNetworkSource,
    private val mapper: IMapper<DogsEntity, DogsDetails>
) : DogsRepository {

    override fun getListCorgi(): Observable<DogsDetails> {
        return service.getListCorgi()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}