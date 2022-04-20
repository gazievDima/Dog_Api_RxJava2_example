package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.ui.models.CorgiDogsDetails
import com.gaziev.dogsapirxjava2example.ui.screens.dogs.IGetListCorgiDogsRepository
import io.reactivex.Observable

class GetListCorgiDogsRepository(
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