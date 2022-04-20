package com.gaziev.dogsapirxjava2example.data.mapper

interface IMapper<T, V> {
    fun map(t: T): V
}