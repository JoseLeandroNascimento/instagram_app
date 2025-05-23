package com.example.instagram_app.register.data

class RegisterEmailRepository(
    private val dataSource: RegisterEmailDataSource
) {

    fun create(email: String, loginCallback: RegisterEmailCallback) {
        dataSource.create(email, loginCallback)
    }

    fun create(
        email: String,
        name: String,
        password: String,
        loginCallback: RegisterEmailCallback
    ) {
        dataSource.create(email, loginCallback)
    }
}