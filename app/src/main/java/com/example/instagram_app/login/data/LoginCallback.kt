package com.example.instagram_app.login.data

import com.example.instagram_app.common.model.UserAuth

interface LoginCallback {

    fun onSuccess(userAuth:UserAuth)

    fun onFailure(message: String)

    fun onComplete()


}