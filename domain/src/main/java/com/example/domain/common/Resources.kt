package com.example.domain.common

sealed class Resources<out  T> {
    data class Success<T>(val data:T):Resources<T>()
    data class NetworkError(val error:NetworkConnectionError):Resources<Nothing>()
    data object Loading:Resources<Nothing>()
    data class serverErrors(val errors:Exceptions):Resources<Nothing>()
}