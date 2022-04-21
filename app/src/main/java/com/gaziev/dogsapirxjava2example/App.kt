package com.gaziev.dogsapirxjava2example

import android.app.Application
import com.gaziev.dogsapirxjava2example.di.dagger.DaggerAppComponent
import com.gaziev.dogsapirxjava2example.di.dagger.DaggerDaggerAppComponent
import okhttp3.OkHttpClient

class App : Application() {

    val daggerAppComponent: DaggerAppComponent = DaggerDaggerAppComponent.create()

}