package com.example.instagram_app.register.data

interface RegisterEmailDataSource {

    fun create(email: String, callback: RegisterEmailCallback)

    fun create(email: String, name: String, password: String, callback: RegisterEmailCallback)

}