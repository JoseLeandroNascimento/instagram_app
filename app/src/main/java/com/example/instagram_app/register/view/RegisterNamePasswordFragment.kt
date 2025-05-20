package com.example.instagram_app.register.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram_app.R
import com.example.instagram_app.databinding.FragmentRegisterNamePasswordBinding

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password) {

    companion object {
        const val KEY_EMAIL = "key_email"
    }

    private var fragmentAttachListener: FragmentAttachListener? = null

    private var binding: FragmentRegisterNamePasswordBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)

        val email = arguments?.getString(KEY_EMAIL)

        Log.i("teste", email ?: "")

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
}