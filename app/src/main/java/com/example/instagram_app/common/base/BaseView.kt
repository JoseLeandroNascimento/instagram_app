package com.example.instagram_app.common.base

import com.example.instagram_app.login.Login.Presenter

interface BaseView<T> {
    var presenter: T
}