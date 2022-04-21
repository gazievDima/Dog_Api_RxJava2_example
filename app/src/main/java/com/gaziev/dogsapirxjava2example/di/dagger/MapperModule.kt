package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.mapper.BreedDogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.CorgiDogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.presentation.models.BreedDogDetails
import com.gaziev.dogsapirxjava2example.presentation.models.CorgiDogsDetails
import com.gaziev.dogsapirxjava2example.presentation.models.DogDetails
import dagger.Module
import dagger.Provides

@Module
class MapperModule() {
    @Provides
    fun provideBreedDogMapper(): IMapper<BreedDogEntity, BreedDogDetails> {
        return BreedDogMapper()
    }

    @Provides
    fun provideCorgiDogsMapper(): IMapper<CorgiDogsEntity, CorgiDogsDetails> {
        return CorgiDogsMapper()
    }

    @Provides
    fun provideDodMapper(): IMapper<DogEntity, DogDetails> {
        return DogMapper()
    }
}