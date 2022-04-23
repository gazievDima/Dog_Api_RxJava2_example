package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogsRemoteEntity
import com.gaziev.dogsapirxjava2example.data.repository.sources.DogsRemoteSource
import com.gaziev.dogsapirxjava2example.presentation.models.DogsRemoteDetails
import com.gaziev.dogsapirxjava2example.presentation.repository.DogsRepository
import io.reactivex.Observable
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(
    private val service: DogsRemoteSource,
    private val mapper: IMapper<DogsRemoteEntity, DogsRemoteDetails>
) : DogsRepository {

    override fun getListCorgi(): Observable<DogsRemoteDetails> {
        return service.getListCorgi()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}