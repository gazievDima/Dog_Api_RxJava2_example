package com.gaziev.dogsapirxjava2example.ui.screens.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.dogsapirxjava2example.data.repository.GetListBoxerDogsRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetListBreedRandomDogRepository
import com.gaziev.dogsapirxjava2example.data.repository.GetRandomDogRepository
import com.gaziev.dogsapirxjava2example.data.repository.NetworkService
import com.gaziev.dogsapirxjava2example.data.source.ApiDogService
import com.gaziev.dogsapirxjava2example.ui.screens.breeds.BreedRandomDogViewModel
import com.gaziev.dogsapirxjava2example.ui.screens.breeds.GetListBreedRandomDog
import com.gaziev.dogsapirxjava2example.ui.screens.dogs.BoxerDogsViewModel
import com.gaziev.dogsapirxjava2example.ui.screens.dogs.GetListBoxerDogs
import com.gaziev.dogsapirxjava2example.ui.screens.random.GetRandomDog
import com.gaziev.dogsapirxjava2example.ui.screens.random.RandomDogViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    private val apiDogService: NetworkService = ApiDogService()

    private val getListBoxerRepository: GetListBoxerDogs = GetListBoxerDogsRepository(apiDogService)
    private val getListBreedRandomDogRepository: GetListBreedRandomDog = GetListBreedRandomDogRepository(apiDogService)
    private val getRandomDogRepository: GetRandomDog = GetRandomDogRepository(apiDogService)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(BreedRandomDogViewModel::class.java) -> return BreedRandomDogViewModel(getListBreedRandomDogRepository) as T
            modelClass.isAssignableFrom(BoxerDogsViewModel::class.java) -> return BoxerDogsViewModel(getListBoxerRepository) as T
            modelClass.isAssignableFrom(RandomDogViewModel::class.java) -> return RandomDogViewModel(getRandomDogRepository) as T
        }
        return modelClass.newInstance()
    }
}