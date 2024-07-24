package com.example.domain.common

data class Exceptions(val msg:String,val statusMsg:String,val httpex :Throwable ):Throwable(msg,httpex) {
}