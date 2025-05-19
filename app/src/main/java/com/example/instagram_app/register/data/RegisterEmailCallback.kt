package com.example.instagram_app.register.data

interface RegisterEmailCallback {

    fun onSuccess()

    fun onFailure(message: String)

    fun onComplete()

}