package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.mapper.DogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogsApiEntity
import com.gaziev.dogsapirxjava2example.data.models.DogApiEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogsApiDetails
import com.gaziev.dogsapirxjava2example.presentation.models.DogApiDetails
import dagger.Module
import dagger.Provides

@Module
class MapperModule() {

    @Provides
    fun provideDogsMapper(): IMapper<DogsApiEntity, DogsApiDetails> {
        return DogsMapper()
    }

    @Provides
    fun provideDodMapper(): IMapper<DogApiEntity, DogApiDetails> {
        return DogMapper()
    }
}