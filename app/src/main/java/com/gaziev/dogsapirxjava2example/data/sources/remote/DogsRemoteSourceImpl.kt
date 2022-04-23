package com.gaziev.dogsapirxjava2example.data.sources.remote

import com.gaziev.dogsapirxjava2example.data.models.DogsRemoteEntity
import com.gaziev.dogsapirxjava2example.data.models.DogRemoteEntity
import com.gaziev.dogsapirxjava2example.data.repository.sources.DogsRemoteSource
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogsRemoteSourceImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val URL_CORGI_DOGS: String,
    private val URL_BREED_DOG: String,
    private val URL_DOG: String
) : DogsRemoteSource {

    override fun getAny(): Observable<DogRemoteEntity> {
        return Observable.create<DogRemoteEntity> {
            try {
                it.onNext(getData(URL_DOG, DogRemoteEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogRemoteEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getCorgi(): Observable<DogRemoteEntity> {
        return Observable.create<DogRemoteEntity> {
            try {
                it.onNext(getData(URL_BREED_DOG, DogRemoteEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogRemoteEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getListCorgi(): Observable<DogsRemoteEntity> {
        return Observable.create<DogsRemoteEntity> {
            try {
                it.onNext(getData(URL_CORGI_DOGS, DogsRemoteEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogsRemoteEntity(listOf(null, null, null), null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    private fun <T> getData(url: String, clazz: Class<T>): T {
        val response = connection(url)
        return if (response.code == 200) convert(response, clazz)
        else DogRemoteEntity(null, null) as T
    }

    private fun connection(url: String): Response {
        val request = Request.Builder().url(url).build()
        return okHttpClient.newCall(request).execute()
    }

    private fun <T> convert(response: Response, clazz: Class<T>): T {
        return Gson().fromJson(response.body?.string(), clazz)
    }

}