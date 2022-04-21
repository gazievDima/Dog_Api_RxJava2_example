package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.mapper.BreedDogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.CorgiDogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.repository.GetBreedRandomDogsRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetListCorgiDogsRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetRandomDogRepository
import com.gaziev.dogsapirxjava2example.data.source.NetworkDogService
import com.gaziev.dogsapirxjava2example.presentation.screens.breed.IGetBreedRandomDogsRepository
import com.gaziev.dogsapirxjava2example.presentation.screens.dogs.IGetListCorgiDogsRepository
import com.gaziev.dogsapirxjava2example.presentation.screens.random.IGetRandomDogRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule() {
    @Provides
    fun provideGetBreedRandomDogsRepository(
        service: NetworkDogService,
        mapper: BreedDogMapper
    ): IGetBreedRandomDogsRepository {
        return GetBreedRandomDogsRepository(service, mapper)
    }

    @Provides
    fun provideGetListCorgiDogsRepository(
        service: NetworkDogService,
        mapper: CorgiDogsMapper
    ): IGetListCorgiDogsRepository {
        return GetListCorgiDogsRepository(service, mapper)
    }

    @Provides
    fun provideGetRandomDogRepository(
        service: NetworkDogService,
        mapper: DogMapper
    ): IGetRandomDogRepository {
        return GetRandomDogRepository(service, mapper)
    }
}