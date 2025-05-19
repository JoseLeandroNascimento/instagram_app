package com.example.instagram_app.register.data

interface RegisterEmailDataSource {

    fun create(email: String, callback: RegisterEmailCallback)
}