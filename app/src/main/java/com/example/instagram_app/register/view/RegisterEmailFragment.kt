package com.example.instagram_app.register.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram_app.R
import com.example.instagram_app.common.base.DependencyInjector
import com.example.instagram_app.common.util.TxtWatcher
import com.example.instagram_app.databinding.FragmentRegisterEmailBinding
import com.example.instagram_app.register.RegisterEmail
import com.example.instagram_app.register.presentation.RegisterEmailPresenter

class RegisterEmailFragment() :
    Fragment(R.layout.fragment_register_email), RegisterEmail.View {

    private var binding: FragmentRegisterEmailBinding? = null
    override lateinit var presenter: RegisterEmail.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterEmailBinding.bind(view)

        presenter = RegisterEmailPresenter(this, DependencyInjector.registerEmailRepository())

        binding?.let {
            with(it) {
                registerTxtLogin.setOnClickListener {
                    activity?.finish()
                }

                registerBtnNext.setOnClickListener {
                    presenter.create(registerEditEmail.text.toString())
                }
                registerEditEmail.addTextChangedListener(walcher)
                registerEditEmail.addTextChangedListener(TxtWatcher {
                    displayEmailFailure(null)
                })

            }
        }
    }

    private val walcher = TxtWatcher {
        binding?.registerBtnNext?.isEnabled = binding?.registerEditEmail?.text.toString()
            .isNotEmpty() && binding?.registerEditEmail?.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerBtnNext?.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding?.registerEditEmailInput?.error = emailError?.let { getString(it) }
    }

    override fun onEmailFailure(message: String) {
        binding?.registerEditEmailInput?.error = message
    }

    override fun goToNameAndPasswordScreen(email: String) {


    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }
}