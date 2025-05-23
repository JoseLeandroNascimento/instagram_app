package com.example.instagram_app.register.presentation

import android.util.Patterns
import com.example.instagram_app.R
import com.example.instagram_app.register.RegisterEmail
import com.example.instagram_app.register.data.RegisterEmailCallback
import com.example.instagram_app.register.data.RegisterEmailRepository

class RegisterEmailPresenter(
    private var view: RegisterEmail.View?,
    private val repository: RegisterEmailRepository
) : RegisterEmail.Presenter {

    override fun create(email: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()


        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }


        if (isEmailValid) {
            view?.showProgress(true)

            repository.create(email, object : RegisterEmailCallback {
                override fun onSuccess() {
                    view?.goToNameAndPasswordScreen(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })
        }
    }

    override fun onDestroy() {
        view = null
    }
}