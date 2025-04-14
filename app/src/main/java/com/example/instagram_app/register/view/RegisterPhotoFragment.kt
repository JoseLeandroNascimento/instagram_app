package com.example.instagram_app.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instagram_app.R
import com.example.instagram_app.common.view.CustomDialog
import com.example.instagram_app.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {

    private var binding:FragmentRegisterPhotoBinding? = null

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterPhotoBinding.bind(view)

        val customDialog = CustomDialog(requireContext())
        customDialog.addButton(R.string.photo, R.string.gallery) { it ->

            when (it.id) {
                R.string.photo -> {

                }
                R.string.gallery -> {

                }
            }

        }

        customDialog.show()
    }
}