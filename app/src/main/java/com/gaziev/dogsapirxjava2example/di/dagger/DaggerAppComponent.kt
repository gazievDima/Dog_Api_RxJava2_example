package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.mapper.BreedDogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.CorgiDogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.repository.GetBreedRandomDogsRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetListCorgiDogsRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetRandomDogRepository
import com.gaziev.dogsapirxjava2example.data.source.NetworkDogService
import com.gaziev.dogsapirxjava2example.presentation.screens.breed.BreedRandomDogFragment
import com.gaziev.dogsapirxjava2example.presentation.screens.dogs.CorgiDogsFragment
import com.gaziev.dogsapirxjava2example.presentation.screens.random.RandomDogFragment
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class, RepositoryModule::class, MapperModule::class, ViewModelModule::class])
interface DaggerAppComponent {
    fun inject(fragment: BreedRandomDogFragment)
    fun inject(fragment: CorgiDogsFragment)
    fun inject(fragment: RandomDogFragment)
}

