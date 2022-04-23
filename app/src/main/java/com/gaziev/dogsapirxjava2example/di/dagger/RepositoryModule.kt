package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.mapper.DogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.repository.DogRepositoryImpl
import com.gaziev.dogsapirxjava2example.data.repository.DogsRepositoryImpl
import com.gaziev.dogsapirxjava2example.data.sources.remote.DogsNetworkSourceImpl
import com.gaziev.dogsapirxjava2example.presentation.repository.DogRepository
import com.gaziev.dogsapirxjava2example.presentation.repository.DogsRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule() {
    @Provides
    fun provideDogRepository(
        service: DogsNetworkSourceImpl,
        mapper: DogMapper
    ): DogRepository {
        return DogRepositoryImpl(service, mapper)
    }

    @Provides
    fun provideDogsRepository(
        service: DogsNetworkSourceImpl,
        mapper: DogsMapper
    ): DogsRepository {
        return DogsRepositoryImpl(service, mapper)
    }

}