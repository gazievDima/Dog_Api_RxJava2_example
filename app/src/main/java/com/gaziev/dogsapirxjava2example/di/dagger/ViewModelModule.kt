package com.gaziev.dogsapirxjava2example.di.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.dogsapirxjava2example.presentation.screens.corgi.CorgiDogViewModel
import com.gaziev.dogsapirxjava2example.presentation.screens.common.ViewModelFactory
import com.gaziev.dogsapirxjava2example.presentation.screens.corgi_list.CorgiDogsViewModel
import com.gaziev.dogsapirxjava2example.presentation.screens.any.AnyDogViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CorgiDogViewModel::class)
    abstract fun bindCorgiDogViewModel(viewModel: CorgiDogViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CorgiDogsViewModel::class)
    abstract fun bindCorgiDogsViewModel(viewModel: CorgiDogsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnyDogViewModel::class)
    abstract fun bindAnyDogViewModel(viewModel: AnyDogViewModel): ViewModel

}