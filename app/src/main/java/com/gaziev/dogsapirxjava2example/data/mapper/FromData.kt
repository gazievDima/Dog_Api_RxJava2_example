package com.gaziev.dogsapirxjava2example.data.mapper

import com.gaziev.dogsapirxjava2example.data.models.BoxersDogsData
import com.gaziev.dogsapirxjava2example.data.models.BreedRandomDogData
import com.gaziev.dogsapirxjava2example.data.models.RandomDogData
import com.gaziev.dogsapirxjava2example.ui.models.BoxersDogs
import com.gaziev.dogsapirxjava2example.ui.models.BreedRandomDog
import com.gaziev.dogsapirxjava2example.ui.models.RandomDog
import io.reactivex.Single

class FromData {

    @JvmName("map1")
    fun map(t: Single<BoxersDogsData>): Single<BoxersDogs> {
       return t.map { BoxersDogs(it.boxerDogs, it.status) }
    }

    @JvmName("map2")
    fun map(t: Single<BreedRandomDogData>): Single<BreedRandomDog> {
        return t.map { BreedRandomDog(it.randomDog, it.status) }

    }

    @JvmName("map3")
    fun map(t: Single<RandomDogData>): Single<RandomDog> {
        return t.map { RandomDog(it.randomDog, it.status) }
    }
}