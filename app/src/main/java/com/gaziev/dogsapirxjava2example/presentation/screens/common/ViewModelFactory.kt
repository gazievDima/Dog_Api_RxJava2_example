package com.gaziev.dogsapirxjava2example.presentation.screens.common

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.dogsapirxjava2example.App
import com.gaziev.dogsapirxjava2example.data.mapper.CorgiDogsMapper
import com.gaziev.dogsapirxjava2example.data.mapper.BreedDogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.DogMapper
import com.gaziev.dogsapirxjava2example.data.mapper.IMapper
import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.data.repository.GetListCorgiDogsRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetBreedRandomDogsRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetRandomDogRepository
import com.gaziev.dogsapirxjava2example.data.repository.INetworkDogService
import com.gaziev.dogsapirxjava2example.data.source.NetworkDogService
import com.gaziev.dogsapirxjava2example.presentation.models.CorgiDogsDetails
import com.gaziev.dogsapirxjava2example.presentation.models.BreedDogDetails
import com.gaziev.dogsapirxjava2example.presentation.models.DogDetails
import com.gaziev.dogsapirxjava2example.presentation.screens.breed.BreedRandomDogViewModel
import com.gaziev.dogsapirxjava2example.presentation.screens.breed.IGetBreedRandomDogsRepository
import com.gaziev.dogsapirxjava2example.presentation.screens.dogs.CorgiDogsViewModel
import com.gaziev.dogsapirxjava2example.presentation.screens.dogs.IGetListCorgiDogsRepository
import com.gaziev.dogsapirxjava2example.presentation.screens.random.IGetRandomDogRepository
import com.gaziev.dogsapirxjava2example.presentation.screens.random.RandomDogViewModel

class ViewModelFactory constructor(application: Application) : ViewModelProvider.Factory {

    private val okHttpClient = (application as App).okhttpClient
    private val apiDogService = NetworkDogService(okHttpClient)

    private val mapperBoxerDogs = CorgiDogsMapper()
    private val mapperBreedDog = BreedDogMapper()
    private val mapperDog = DogMapper()

    private val getListBoxerRepository = GetListCorgiDogsRepository(apiDogService, mapperBoxerDogs)
    private val getBreedRandomDogRepository = GetBreedRandomDogsRepository(apiDogService, mapperBreedDog)
    private val getRandomDogRepository = GetRandomDogRepository(apiDogService, mapperDog)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(BreedRandomDogViewModel::class.java) -> return BreedRandomDogViewModel(getBreedRandomDogRepository) as T
            modelClass.isAssignableFrom(CorgiDogsViewModel::class.java) -> return CorgiDogsViewModel(getListBoxerRepository) as T
            modelClass.isAssignableFrom(RandomDogViewModel::class.java) -> return RandomDogViewModel(getRandomDogRepository) as T
        }
        return modelClass.newInstance()
    }
}