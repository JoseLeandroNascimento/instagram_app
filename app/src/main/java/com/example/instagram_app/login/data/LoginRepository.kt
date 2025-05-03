package com.example.instagram_app.login.data

class LoginRepository(
    private val dataSource: LoginDataSource
) {

    fun login(email: String, password: String,loginCallback: LoginCallback) {
        dataSource.login(email, password,loginCallback)
    }
}