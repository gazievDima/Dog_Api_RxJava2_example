package com.gaziev.dogsapirxjava2example.di.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.dogsapirxjava2example.presentation.screens.breed.BreedRandomDogViewModel
import com.gaziev.dogsapirxjava2example.presentation.screens.common.ViewModelFactory
import com.gaziev.dogsapirxjava2example.presentation.screens.dogs.CorgiDogsViewModel
import com.gaziev.dogsapirxjava2example.presentation.screens.random.RandomDogViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BreedRandomDogViewModel::class)
    abstract fun bindBreedRandomDogViewModel(viewModel: BreedRandomDogViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CorgiDogsViewModel::class)
    abstract fun bindCorgiDogsViewModel(viewModel: CorgiDogsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RandomDogViewModel::class)
    abstract fun bindRandomDogViewModel(viewModel: RandomDogViewModel): ViewModel

}