package com.gaziev.dogsapirxjava2example.data.source

import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.data.repository.INetworkDogService
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDogService @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val URL_CORGI_DOGS: String,
    private val URL_BREED_DOG: String,
    private val URL_DOG: String
) : INetworkDogService {

    override fun getRandomDog(): Observable<DogEntity> {
        return Observable.create<DogEntity> {
            try {
                it.onNext(getData(URL_DOG, DogEntity::class.java))
            } catch (e: Exception) {
                it.onNext(DogEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getBreedRandomDog(): Observable<BreedDogEntity> {
        return Observable.create<BreedDogEntity> {
            try {
                it.onNext(getData(URL_BREED_DOG, BreedDogEntity::class.java))
            } catch (e: Exception) {
                it.onNext(BreedDogEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getCorgiDogs(): Observable<CorgiDogsEntity> {
        return Observable.create<CorgiDogsEntity> {
            try {
                it.onNext(getData(URL_CORGI_DOGS, CorgiDogsEntity::class.java))
            } catch (e: Exception) {
                it.onNext(CorgiDogsEntity(listOf(null, null, null), null))
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