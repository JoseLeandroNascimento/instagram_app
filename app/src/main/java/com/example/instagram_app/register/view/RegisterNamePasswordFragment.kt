package com.example.instagram_app.register.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.instagram_app.R
import com.example.instagram_app.common.base.DependencyInjector
import com.example.instagram_app.common.util.TxtWatcher
import com.example.instagram_app.databinding.FragmentRegisterNamePasswordBinding
import com.example.instagram_app.register.RegisterNameAndPassword
import com.example.instagram_app.register.presentation.RegisterNameAndPasswordlPresenter

class RegisterNamePasswordFragment() : Fragment(R.layout.fragment_register_name_password),
    RegisterNameAndPassword.View {

    override lateinit var presenter: RegisterNameAndPassword.Presenter

    companion object {
        const val KEY_EMAIL = "key_email"
    }

    private var fragmentAttachListener: FragmentAttachListener? = null

    private var binding: FragmentRegisterNamePasswordBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)

        val email =
            arguments?.getString(KEY_EMAIL) ?: throw IllegalArgumentException("Email not found")

        val repository = DependencyInjector.registerEmailRepository()
        presenter = RegisterNameAndPasswordlPresenter(this, repository)

        binding?.let {
            with(it) {

                registerTxtLogin.setOnClickListener {
                    activity?.finish()
                }

                registerNameBtnNext.setOnClickListener {
                    presenter.create(
                        email,
                        registerEditName.text.toString(),
                        registerEditPassword.text.toString(),
                        registerEditConfirm.text.toString()
                    )
                }

                registerEditName.addTextChangedListener(walcher)
                registerEditPassword.addTextChangedListener(walcher)
                registerEditConfirm.addTextChangedListener(walcher)

                registerEditName.addTextChangedListener(TxtWatcher {
                    displayNameFailure(null)
                })

                registerEditPassword.addTextChangedListener(TxtWatcher {
                    displayPasswordFailure(null)
                })

                registerEditConfirm.addTextChangedListener(TxtWatcher {
                    displayPasswordFailure(null)
                })

            }
        }

    }

    private val walcher = TxtWatcher {
        binding?.registerNameBtnNext?.isEnabled =
            binding?.registerEditName?.text.toString().isNotEmpty() &&
                    binding?.registerEditPassword?.text.toString().isNotEmpty() &&
                    binding?.registerEditConfirm?.text.toString().isNotEmpty()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener) {
            fragmentAttachListener = context
        }
    }


    override fun onDestroy() {
        binding = null

        fragmentAttachListener = null
        super.onDestroy()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerNameBtnNext?.showProgress(enabled)
    }

    override fun displayNameFailure(emailError: Int?) {
        binding?.registerEditNameInput?.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding?.registerEditPasswordInput?.error = passwordError?.let { getString(it) }
    }

    override fun onCreateFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateSuccess(name: String) {

    }


}