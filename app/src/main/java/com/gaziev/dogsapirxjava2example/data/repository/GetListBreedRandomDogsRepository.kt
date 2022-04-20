package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.ui.models.BreedDogDetails
import com.gaziev.dogsapirxjava2example.ui.screens.breeds.IGetListBreedRandomDogsRepository
import io.reactivex.Observable
import io.reactivex.Single

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