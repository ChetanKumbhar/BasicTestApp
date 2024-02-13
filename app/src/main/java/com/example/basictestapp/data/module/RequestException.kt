package com.example.basictestapp.data.module

class RequestException(val code: Int, message: String) : Throwable(message)