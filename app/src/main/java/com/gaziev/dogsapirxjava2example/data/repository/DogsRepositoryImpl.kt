package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogsApiEntity
import com.gaziev.dogsapirxjava2example.data.repository.sources.DogsNetworkSource
import com.gaziev.dogsapirxjava2example.presentation.models.DogsApiDetails
import com.gaziev.dogsapirxjava2example.presentation.repository.DogsRepository
import io.reactivex.Observable
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(
    private val service: DogsNetworkSource,
    private val mapper: IMapper<DogsApiEntity, DogsApiDetails>
) : DogsRepository {

    override fun getListCorgi(): Observable<DogsApiDetails> {
        return service.getListCorgi()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}