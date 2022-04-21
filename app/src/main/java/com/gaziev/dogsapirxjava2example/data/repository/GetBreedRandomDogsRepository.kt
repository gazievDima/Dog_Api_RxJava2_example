package com.gaziev.dogsapirxjava2example.data.repository

import com.gaziev.dogsapirxjava2example.data.mapper.BreedDogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.CorgiDogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.data.source.NetworkDogService
import com.gaziev.dogsapirxjava2example.presentation.models.BreedDogDetails
import com.gaziev.dogsapirxjava2example.presentation.models.CorgiDogsDetails
import com.gaziev.dogsapirxjava2example.presentation.screens.breed.IGetBreedRandomDogsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBreedRandomDogsRepository(
    private val service: INetworkDogService,
    private val mapper: IMapper<BreedDogEntity, BreedDogDetails>
) : IGetBreedRandomDogsRepository {

    override fun execute(): Observable<BreedDogDetails> {
        return service.getBreedRandomDog()
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}