package com.example.instagram_app.common.base

import com.example.instagram_app.login.data.FakeDataSource
import com.example.instagram_app.login.data.LoginRepository

object DependencyInjector {

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

}