package com.gaziev.dogsapirxjava2example.di.dagger

import com.gaziev.dogsapirxjava2example.data.sources.remote.DogsApiSourceImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class SourceModule() {

    @Singleton
    @Provides
    fun provideDogsNetworkSource(): DogsApiSourceImpl {
        return DogsApiSourceImpl(
            OkHttpClient(),
            "https://dog.ceo/api/breed/corgi/images",
            "https://dog.ceo/api/breed/corgi/images/random",
            "https://dog.ceo/api/breeds/image/random"
        )
    }
}