package com.gaziev.dogsapirxjava2example.presentation.screens.breed

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.dogsapirxjava2example.data.repository.GetBreedRandomDogsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class BreedRandomDogViewModel @Inject constructor(
    private val repository: IGetBreedRandomDogsRepository
) : ViewModel() {

    init {
        getBreedRandomDog()
    }

    private var disposable: Disposable? = null
    private val _dogImage: MutableLiveData<String> = MutableLiveData()
    val dogImage: LiveData<String> = _dogImage

    fun getBreedRandomDog() {
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