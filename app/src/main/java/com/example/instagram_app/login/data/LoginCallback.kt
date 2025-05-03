package com.example.instagram_app.login.data

interface LoginCallback {

    fun onSuccess()

    fun onFailure(message: String)

    fun onComplete()


}