package com.gaziev.dogsapirxjava2example.presentation.screens.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class RandomDogViewModel(
    private val repository: IGetRandomDogRepository
) : ViewModel() {

    private var disposable: Disposable? = null
    private val _dogImage: MutableLiveData<String> = MutableLiveData()
    val dogImage: LiveData<String> = _dogImage

    fun getRandomDog() {
       disposable = repository.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    _dogImage.value = it.randomDog
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}