package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.mapper.DogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.DogsRemoteEntity
import com.gaziev.dogsapirxjava2example.data.models.DogRemoteEntity
import com.gaziev.dogsapirxjava2example.presentation.models.DogsRemoteDetails
import com.gaziev.dogsapirxjava2example.presentation.models.DogRemoteDetails
import dagger.Module
import dagger.Provides

@Module
class MapperModule() {

    @Provides
    fun provideDogsMapper(): IMapper<DogsRemoteEntity, DogsRemoteDetails> {
        return DogsMapper()
    }

    @Provides
    fun provideDodMapper(): IMapper<DogRemoteEntity, DogRemoteDetails> {
        return DogMapper()
    }
}