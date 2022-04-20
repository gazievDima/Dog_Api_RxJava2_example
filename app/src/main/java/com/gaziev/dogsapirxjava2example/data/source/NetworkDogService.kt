package com.gaziev.dogsapirxjava2example.data.source

import android.content.ContentValues.TAG
import android.util.Log
import com.gaziev.dogsapirxjava2example.data.models.CorgiDogsEntity
import com.gaziev.dogsapirxjava2example.data.models.BreedDogEntity
import com.gaziev.dogsapirxjava2example.data.models.DogEntity
import com.gaziev.dogsapirxjava2example.data.repository.INetworkDogService
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request

class NetworkDogService(
    private val okHttpClient: OkHttpClient
) : INetworkDogService {

    companion object {
        const val URL_CORGI_DOGS = "https://dog.ceo/api/breed/corgi/images"
        const val URL_BREED_DOG = "https://dog.ceo/api/breed/corgi/images/random"
        const val URL_DOG = "https://dog.ceo/api/breeds/image/random"
    }

    override fun getRandomDog(): Observable<DogEntity> {
        return Observable.create<DogEntity> {
            val request = Request.Builder().url(URL_DOG).build()

            try {
                val response = okHttpClient.newCall(request).execute()
                if (response.code == 200) {
                    val body = Gson().fromJson(response.body?.string(), DogEntity::class.java)
                    it.onNext(body)
                } else {
                    it.onNext(DogEntity(null, null))
                }
            } catch (e: Exception) {
                it.onNext(DogEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getBreedRandomDog(): Observable<BreedDogEntity> {
        return Observable.create<BreedDogEntity> {
            val request = Request.Builder().url(URL_BREED_DOG).build()

            try {
                val response = okHttpClient.newCall(request).execute()
                if (response.code == 200) {
                    val body =
                        Gson().fromJson(response.body?.string(), BreedDogEntity::class.java)
                    it.onNext(body)
                } else {
                    it.onNext(BreedDogEntity(null, null))
                }
            } catch (e: Exception) {
                it.onNext(BreedDogEntity(null, null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

    override fun getCorgiDogs(): Observable<CorgiDogsEntity> {
        return Observable.create<CorgiDogsEntity> {
            val request = Request.Builder().url(URL_CORGI_DOGS).build()

            try {
                val response = okHttpClient.newCall(request).execute()
                if (response.code == 200) {
                    val body =
                        Gson().fromJson(response.body?.string(), CorgiDogsEntity::class.java)
                    it.onNext(body)
                } else {
                    it.onNext(CorgiDogsEntity(listOf(null, null, null), null))
                }
            } catch (e: Exception) {
                it.onNext(CorgiDogsEntity(listOf(null, null, null), null))
            }
        }.subscribeOn(Schedulers.newThread())
    }

}