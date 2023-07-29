package com.msp.spacex.utils

sealed class Results<out R>{
    data class Success<out T>(val data:T) : Results<T>()
    data class Error(val exception: java.lang.Exception) : Results<Nothing>()
    object Loading : Results<Nothing>()
}

val <T> T.exhaustive : T
    get() = this