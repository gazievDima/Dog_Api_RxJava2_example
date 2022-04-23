package com.gaziev.dogsapirxjava2example.data.sources.remote

import com.gaziev.dogsapirxjava2example.data.models.DogsApiEntity
import com.gaziev.dogsapirxjava2example.data.models.DogApiEntity
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
class DogsApiSourceImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val URL_CORGI_DOGS: String,
    private val URL_BREED_DOG: String,
    private val URL_DOG: String
) : DogsNetworkSource {

    override fun getAny(): Observable<DogApiEntity> {
        return Observable.create<DogApiEntity> {
            try {
                it.onNext(getData(URL_DOG, DogApiEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogApiEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getCorgi(): Observable<DogApiEntity> {
        return Observable.create<DogApiEntity> {
            try {
                it.onNext(getData(URL_BREED_DOG, DogApiEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogApiEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getListCorgi(): Observable<DogsApiEntity> {
        return Observable.create<DogsApiEntity> {
            try {
                it.onNext(getData(URL_CORGI_DOGS, DogsApiEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogsApiEntity(listOf(null, null, null), null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    private fun <T> getData(url: String, clazz: Class<T>): T {
        val response = connection(url)
        return if (response.code == 200) convert(response, clazz)
        else DogApiEntity(null, null) as T
    }

    private fun connection(url: String): Response {
        val request = Request.Builder().url(url).build()
        return okHttpClient.newCall(request).execute()
    }

    private fun <T> convert(response: Response, clazz: Class<T>): T {
        return Gson().fromJson(response.body?.string(), clazz)
    }

}