package com.gaziev.dogsapirxjava2example.data.source

import com.gaziev.dogsapirxjava2example.data.models.BoxersDogsData
import com.gaziev.dogsapirxjava2example.data.models.BreedRandomDogData
import com.gaziev.dogsapirxjava2example.data.models.RandomDogData
import com.gaziev.dogsapirxjava2example.data.repository.NetworkService
import io.reactivex.Single

class ApiDogService : NetworkService {

    override fun getRandomDog(): Single<RandomDogData> {
        return Single.just(
            RandomDogData(
                null,
                null
            )
        )
    }

    override fun getBreedRandomDog(): Single<BreedRandomDogData> {
        return Single.just(
            BreedRandomDogData(
                null,
                null
            )
        )
    }

    override fun getBoxerDogs(): Single<BoxersDogsData> {
        return Single.just(
            BoxersDogsData(
                null,
                null
            )
        )
    }

}