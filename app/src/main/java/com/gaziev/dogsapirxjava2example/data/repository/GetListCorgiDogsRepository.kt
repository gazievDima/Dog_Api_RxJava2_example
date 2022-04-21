package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.CorgiDogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.data.source.NetworkDogService
import com.gaziev.dogsapirxjava2example.presentation.models.CorgiDogsDetails
import com.gaziev.dogsapirxjava2example.presentation.screens.dogs.IGetListCorgiDogsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetListCorgiDogsRepository @Inject constructor(
    private val service: INetworkDogService,
    private val mapper: IMapper<CorgiDogsEntity, CorgiDogsDetails>
) : IGetListCorgiDogsRepository {

    override fun execute(): Observable<CorgiDogsDetails> {
        return service.getCorgiDogs()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}