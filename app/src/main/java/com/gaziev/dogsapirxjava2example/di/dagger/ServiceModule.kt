package com.gaziev.dogsapirxjava2example.di.dagger

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class ServiceModule() {
    @Provides
    fun provideNetworkDogService(): OkHttpClient {
        return OkHttpClient()
    }
}