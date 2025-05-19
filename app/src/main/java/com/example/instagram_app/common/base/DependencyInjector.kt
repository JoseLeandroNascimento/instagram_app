package com.example.instagram_app.common.base

import com.example.instagram_app.login.data.FakeDataSource
import com.example.instagram_app.login.data.LoginRepository
import com.example.instagram_app.register.data.FakeRegisterEmailDataSource
import com.example.instagram_app.register.data.RegisterEmailRepository

object DependencyInjector {

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterEmailRepository {
        return RegisterEmailRepository(FakeRegisterEmailDataSource())
    }

}