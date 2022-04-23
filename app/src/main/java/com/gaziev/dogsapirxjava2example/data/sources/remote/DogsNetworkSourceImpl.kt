package com.gaziev.dogsapirxjava2example.data.sources.remote

import com.gaziev.dogsapirxjava2example.data.models.DogsEntity
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.data.repository.sources.DogsNetworkSource
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogsNetworkSourceImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val URL_CORGI_DOGS: String,
    private val URL_BREED_DOG: String,
    private val URL_DOG: String
) : DogsNetworkSource {

    override fun getAny(): Observable<DogEntity> {
        return Observable.create<DogEntity> {
            try {
                it.onNext(getData(URL_DOG, DogEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getCorgi(): Observable<DogEntity> {
        return Observable.create<DogEntity> {
            try {
                it.onNext(getData(URL_BREED_DOG, DogEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getListCorgi(): Observable<DogsEntity> {
        return Observable.create<DogsEntity> {
            try {
                it.onNext(getData(URL_CORGI_DOGS, DogsEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogsEntity(listOf(null, null, null), null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    private fun <T> getData(url: String, clazz: Class<T>): T {
        val response = connection(url)
        return if (response.code == 200) convert(response, clazz)
        else DogEntity(null, null) as T
    }

    private fun connection(url: String): Response {
        val request = Request.Builder().url(url).build()
        return okHttpClient.newCall(request).execute()
    }

    private fun <T> convert(response: Response, clazz: Class<T>): T {
        return Gson().fromJson(response.body?.string(), clazz)
    }

}