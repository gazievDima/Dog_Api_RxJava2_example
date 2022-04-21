package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.mapper.BreedDogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.CorgiDogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule() {
    @Provides
    fun provideBreedDogMapper(): BreedDogMapper {
        return BreedDogMapper()
    }

    @Provides
    fun provideCorgiDogsMapper(): CorgiDogsMapper {
        return CorgiDogsMapper()
    }

    @Provides
    fun provideDodMapper(): DogMapper {
        return DogMapper()
    }
}