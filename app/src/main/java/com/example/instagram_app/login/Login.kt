package com.example.instagram_app.login

import com.example.instagram_app.common.base.BasePresenter
import com.example.instagram_app.common.base.BaseView

interface Login {

    interface Presenter : BasePresenter {
        fun login(email: String, password: String)
    }

    interface View : BaseView<Presenter> {

        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized()

    }

}