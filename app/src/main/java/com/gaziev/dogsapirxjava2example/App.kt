package com.gaziev.dogsapirxjava2example

import android.app.Application
import com.gaziev.dogsapirxjava2example.di.dagger.AppComponent
import com.gaziev.dogsapirxjava2example.di.dagger.DaggerAppComponent

class App : Application() {

    val daggerAppComponent: AppComponent = DaggerAppComponent.create()

}