package com.example.instagram_app.login.data

import android.os.Handler
import android.os.Looper

class FakeDataSource : LoginDataSource {

    override fun login(email: String, password: String, callback: LoginCallback) {

        Handler(Looper.getMainLooper()).postDelayed({

            if (email == "teste@gmail.com" && password == "12345678") {
                callback.onSuccess()
            } else {
                callback.onFailure("Usuário não encontrado")
            }
            callback.onComplete()
        }, 2000)
    }
}