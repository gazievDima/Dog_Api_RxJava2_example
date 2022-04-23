package com.gaziev.dogsapirxjava2example.presentation.repository

import com.gaziev.dogsapirxjava2example.presentation.models.DogsDetails
import io.reactivex.Observable

interface DogsRepository {
    fun getListCorgi(): Observable<DogsDetails>
}