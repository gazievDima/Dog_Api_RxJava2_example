package com.gaziev.dogsapirxjava2example.presentation.screens.any

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.dogsapirxjava2example.presentation.repository.DogRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class AnyDogViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {

    init {
        getRandomDog()
    }

    private var disposable: Disposable? = null
    private val _dogImage: MutableLiveData<String> = MutableLiveData()
    val dogImage: LiveData<String> = _dogImage

    fun getRandomDog() {
       disposable = repository.getAny()
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