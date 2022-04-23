package com.gaziev.dogsapirxjava2example.presentation.repository

import com.gaziev.dogsapirxjava2example.presentation.models.DogsApiDetails
import io.reactivex.Observable

interface DogsRepository {
    fun getListCorgi(): Observable<DogsApiDetails>
}