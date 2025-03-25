package com.example.instagram_app.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instagram_app.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var button: LoadingButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = findViewById<LoadingButton>(R.id.login_btn_enter)

        val editTextEmail = findViewById<TextInputEditText>(R.id.login_edit_email)
        val editTextPassword = findViewById<TextInputEditText>(R.id.login_edit_senha)

        editTextEmail.addTextChangedListener(walcher)
        editTextPassword.addTextChangedListener(walcher)

        button.setOnClickListener {
            button.showProgress(true)
            findViewById<TextInputLayout>(R.id.login_edit_email_input).error = "E-mail é inválido"
            findViewById<TextInputLayout>(R.id.login_edit_senha_input).error = "Senha é inválida"
            Handler(Looper.getMainLooper()).postDelayed({
                button.showProgress(false)
            },2000)
        }
    }

    private val walcher = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            button.isEnabled = s.toString().isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }

}