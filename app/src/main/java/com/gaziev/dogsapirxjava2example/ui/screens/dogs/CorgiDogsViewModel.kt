package com.gaziev.dogsapirxjava2example.ui.screens.dogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class CorgiDogsViewModel(
    private val repository: IGetListCorgiDogsRepository
) : ViewModel() {

    private var disposable: Disposable? = null
    private val _listCorgi: MutableLiveData<List<String?>> = MutableLiveData()
    val listCorgi: LiveData<List<String?>> = _listCorgi

    fun getListCorgiDogs() {
        disposable = repository.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    _listCorgi.value = it.corgiDogs
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}