package com.gaziev.dogsapirxjava2example.ui.screens.dogs

import com.gaziev.dogsapirxjava2example.ui.models.BoxersDogs
import io.reactivex.Single

interface GetListBoxerDogs {
    fun execute(): Single<BoxersDogs>
}