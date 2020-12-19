package com.example.mvvm_learn.utils

sealed class ResultReading<R> {
    data class onSuccess<T>(val data: T, val status: Status) : ResultReading<T>()
    data class onLoading<T>(val data: T?, val status: Status) : ResultReading<T>()
    data class onError<T>(val message: String, val status: Status) :
        ResultReading<T>()
}
