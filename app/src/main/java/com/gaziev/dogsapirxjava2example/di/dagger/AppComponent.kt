package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.presentation.screens.corgi.CorgiDogFragment
import com.gaziev.dogsapirxjava2example.presentation.screens.corgi_list.CorgiDogsFragment
import com.gaziev.dogsapirxjava2example.presentation.screens.any.AnyDogFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SourceModule::class, RepositoryModule::class, MapperModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(fragment: CorgiDogFragment)
    fun inject(fragment: CorgiDogsFragment)
    fun inject(fragment: AnyDogFragment)
}

