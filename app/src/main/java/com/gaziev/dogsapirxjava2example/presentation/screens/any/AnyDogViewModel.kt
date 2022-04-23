package com.gaziev.dogsapirxjava2example.presentation.screens.any

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.dogsapirxjava2example.presentation.repository.DogRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class AnyDogViewModel @Inject constructor(
    private val dogRepository: DogRepository
) : ViewModel() {

    init {
        getRandomDog()
    }

    private var disposable: Disposable? = null
    private val _imageUrl: MutableLiveData<String> = MutableLiveData()
    val imageUrl: LiveData<String> = _imageUrl

    fun getRandomDog() {
       disposable = dogRepository.getAny()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    _imageUrl.value = it.imageUrl
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}