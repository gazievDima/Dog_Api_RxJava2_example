package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.data.source.NetworkDogService
import com.gaziev.dogsapirxjava2example.presentation.models.DogDetails
import com.gaziev.dogsapirxjava2example.presentation.screens.random.IGetRandomDogRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetRandomDogRepository @Inject constructor(
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