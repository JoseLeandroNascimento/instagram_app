package com.example.instagram_app.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instagram_app.R
import com.example.instagram_app.common.util.TxtWatcher
import com.example.instagram_app.databinding.ActivityLoginBinding
import com.example.instagram_app.login.Login
import com.example.instagram_app.login.presentation.LoginPresenter

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding
    override lateinit var presenter: Login.Presenter

    private lateinit var button: LoadingButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate((layoutInflater))
        setContentView(binding.root)

        presenter = LoginPresenter(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = binding.loginBtnEnter

        val editTextEmail = binding.loginEditEmail
        val editTextPassword = binding.loginEditSenha

        editTextEmail.addTextChangedListener(walcher)
        editTextEmail.addTextChangedListener(TxtWatcher{
            displayEmailFailure(null)
        })
        editTextPassword.addTextChangedListener(walcher)
        editTextPassword.addTextChangedListener(TxtWatcher{
            displayPasswordFailure(null)
        })


        button.setOnClickListener {

            presenter.login(
                editTextEmail.text.toString(),
                editTextPassword.text.toString()
            )

            Handler(Looper.getMainLooper()).postDelayed({
                button.showProgress(false)
            }, 2000)
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private val walcher = TxtWatcher {
        binding.loginBtnEnter.isEnabled = binding.loginEditEmail.text.toString()
            .isNotEmpty() && binding.loginEditSenha.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding.loginBtnEnter.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.loginEditEmailInput.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.loginEditSenhaInput.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {

    }

    override fun onUserUnauthorized() {

    }


}