package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.source.NetworkDogService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class ServiceModule() {

    @Singleton
    @Provides
    fun provideNetworkDogService(): NetworkDogService {
        return NetworkDogService(
            OkHttpClient(),
            "https://dog.ceo/api/breed/corgi/images",
            "https://dog.ceo/api/breed/corgi/images/random",
            "https://dog.ceo/api/breeds/image/random"
        )
    }
}