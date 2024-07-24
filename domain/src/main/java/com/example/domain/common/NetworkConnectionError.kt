package com.example.domain.common

data class NetworkConnectionError(val t:Throwable):Throwable() {}