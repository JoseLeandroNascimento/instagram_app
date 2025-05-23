package com.example.instagram_app.register

import androidx.annotation.StringRes
import com.example.instagram_app.common.base.BasePresenter
import com.example.instagram_app.common.base.BaseView

interface RegisterNameAndPassword {

    interface Presenter : BasePresenter {

        fun create(email:String,name: String, password: String, confirm: String)
    }

    interface View : BaseView<Presenter> {

        fun showProgress(enabled: Boolean)

        fun displayNameFailure(@StringRes emailError: Int?)

        fun displayPasswordFailure(@StringRes passwordError: Int?)

        fun onCreateFailure(message: String)

        fun onCreateSuccess(name: String)
    }
}