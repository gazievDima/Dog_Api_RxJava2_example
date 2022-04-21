package com.gaziev.dogsapirxjava2example.ui.screens.common

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
import com.gaziev.dogsapirxjava2example.data.repository.GetListBreedRandomDogsRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetRandomDogRepository
import com.gaziev.dogsapirxjava2example.data.repository.INetworkDogService
import com.gaziev.dogsapirxjava2example.data.source.NetworkDogService
import com.gaziev.dogsapirxjava2example.ui.models.CorgiDogsDetails
import com.gaziev.dogsapirxjava2example.ui.models.BreedDogDetails
import com.gaziev.dogsapirxjava2example.ui.models.DogDetails
import com.gaziev.dogsapirxjava2example.ui.screens.breed.BreedRandomDogViewModel
import com.gaziev.dogsapirxjava2example.ui.screens.breed.IGetListBreedRandomDogsRepository
import com.gaziev.dogsapirxjava2example.ui.screens.dogs.CorgiDogsViewModel
import com.gaziev.dogsapirxjava2example.ui.screens.dogs.IGetListCorgiDogsRepository
import com.gaziev.dogsapirxjava2example.ui.screens.random.IGetRandomDogRepository
import com.gaziev.dogsapirxjava2example.ui.screens.random.RandomDogViewModel

class ViewModelFactory(application: Application) : ViewModelProvider.Factory {

    private val okHttpClient = (application as App).okhttpClient
    private val apiDogService: INetworkDogService = NetworkDogService(okHttpClient)
    private val mapperBoxerDogs: IMapper<CorgiDogsEntity, CorgiDogsDetails> = CorgiDogsMapper()
    private val mapperBreedDogEntity: IMapper<BreedDogEntity, BreedDogDetails> = BreedDogMapper()
    private val mapperDogEntity: IMapper<DogEntity, DogDetails> = DogMapper()

    private val getListBoxerRepository: IGetListCorgiDogsRepository = GetListCorgiDogsRepository(apiDogService, mapperBoxerDogs)
    private val getListBreedRandomDogRepository: IGetListBreedRandomDogsRepository = GetListBreedRandomDogsRepository(apiDogService, mapperBreedDogEntity)
    private val getRandomDogRepository: IGetRandomDogRepository = GetRandomDogRepository(apiDogService, mapperDogEntity)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(BreedRandomDogViewModel::class.java) -> return BreedRandomDogViewModel(getListBreedRandomDogRepository) as T
            modelClass.isAssignableFrom(CorgiDogsViewModel::class.java) -> return CorgiDogsViewModel(getListBoxerRepository) as T
            modelClass.isAssignableFrom(RandomDogViewModel::class.java) -> return RandomDogViewModel(getRandomDogRepository) as T
        }
        return modelClass.newInstance()
    }
}