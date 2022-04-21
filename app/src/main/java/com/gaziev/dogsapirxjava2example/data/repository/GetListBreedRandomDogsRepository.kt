package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.presentation.models.BreedDogDetails
import com.gaziev.dogsapirxjava2example.presentation.screens.breed.IGetListBreedRandomDogsRepository
import io.reactivex.Observable

class GetListBreedRandomDogsRepository(
    private val service: INetworkDogService,
    private val mapper: IMapper<BreedDogEntity, BreedDogDetails>
) : IGetListBreedRandomDogsRepository {

    override fun execute(): Observable<BreedDogDetails> {
        return service.getBreedRandomDog()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}