package com.gaziev.dogsapirxjava2example.presentation.screens.dogs

import com.gaziev.dogsapirxjava2example.presentation.models.CorgiDogsDetails
import io.reactivex.Observable

interface IGetListCorgiDogsRepository {
    fun execute(): Observable<CorgiDogsDetails>
}