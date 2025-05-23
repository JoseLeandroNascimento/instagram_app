package com.example.instagram_app.register.data

import android.os.Handler
import android.os.Looper
import com.example.instagram_app.common.model.Database
import com.example.instagram_app.common.model.UserAuth
import java.util.UUID

class FakeRegisterEmailDataSource : RegisterEmailDataSource {

    override fun create(email: String, callback: RegisterEmailCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callback.onSuccess()
            } else {
                callback.onFailure("Usuário já cadastrado")
            }

            callback.onComplete()
        }, 2000)
    }

    override fun create(
        email: String,
        name: String,
        password: String,
        callback: RegisterEmailCallback
    ) {

        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth != null) {
                callback.onFailure("Usuário já existe")
            } else {
                val created: Boolean = Database.usersAuth.add(
                    UserAuth(UUID.randomUUID().toString(), name, email, password)
                )

                if (created) {
                    callback.onSuccess()
                } else {
                    callback.onFailure("Erro interno no servidor")
                }
            }

            callback.onComplete()
        }, 2000)
    }
}