package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.mapper.DogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogsEntity
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogsDetails
import com.gaziev.dogsapirxjava2example.presentation.models.DogDetails
import dagger.Module
import dagger.Provides

@Module
class MapperModule() {

    @Provides
    fun provideDogsMapper(): IMapper<DogsEntity, DogsDetails> {
        return DogsMapper()
    }

    @Provides
    fun provideDodMapper(): IMapper<DogEntity, DogDetails> {
        return DogMapper()
    }
}