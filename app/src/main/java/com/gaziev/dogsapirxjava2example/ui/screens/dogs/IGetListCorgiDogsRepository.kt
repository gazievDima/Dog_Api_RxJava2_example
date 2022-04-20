package com.gaziev.dogsapirxjava2example.ui.screens.dogs

import com.gaziev.dogsapirxjava2example.ui.models.CorgiDogsDetails
import io.reactivex.Observable
import io.reactivex.Single

interface IGetListCorgiDogsRepository {
    fun execute(): Observable<CorgiDogsDetails>
}