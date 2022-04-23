package com.gaziev.dogsapirxjava2example.presentation.screens.corgi_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.dogsapirxjava2example.presentation.repository.DogsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class CorgiDogsViewModel @Inject constructor(
    private val dogsRepository: DogsRepository
) : ViewModel() {

    init {
        getListCorgiDogs()
    }

    private var disposable: Disposable? = null
    private val _listImageUrl: MutableLiveData<List<String?>> = MutableLiveData()
    val listImageUrl: LiveData<List<String?>> = _listImageUrl

    private fun getListCorgiDogs() {
        disposable = dogsRepository.getListCorgi()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    _listImageUrl.value = it.listImageUrl
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}