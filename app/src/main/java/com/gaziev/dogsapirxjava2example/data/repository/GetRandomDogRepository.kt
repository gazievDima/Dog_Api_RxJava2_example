package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.ui.models.DogDetails
import com.gaziev.dogsapirxjava2example.ui.screens.random.IGetRandomDogRepository
import io.reactivex.Observable
import io.reactivex.Single

class GetRandomDogRepository(
    private val service: INetworkDogService,
    private val mapper: IMapper<DogEntity, DogDetails>
) : IGetRandomDogRepository {

    override fun execute(): Observable<DogDetails> {
        return service.getRandomDog()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}