package com.gaziev.dogsapirxjava2example

import android.app.Application
import okhttp3.OkHttpClient

class App : Application() {

    val okhttpClient: OkHttpClient by lazy { OkHttpClient() }

}