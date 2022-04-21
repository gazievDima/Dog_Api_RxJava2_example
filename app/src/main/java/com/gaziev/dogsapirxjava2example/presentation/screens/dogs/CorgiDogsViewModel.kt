package com.gaziev.dogsapirxjava2example.presentation.screens.dogs

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaziev.dogsapirxjava2example.data.repository.GetListCorgiDogsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class CorgiDogsViewModel @Inject constructor(
    private val repository: IGetListCorgiDogsRepository
) : ViewModel() {

    init {
        getListCorgiDogs()
    }

    private var disposable: Disposable? = null
    private val _listCorgi: MutableLiveData<List<String?>> = MutableLiveData()
    val listCorgi: LiveData<List<String?>> = _listCorgi

    private fun getListCorgiDogs() {
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