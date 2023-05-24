package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentAdminLoginBinding


class AdminLoginFragment : BaseFragment() {

    private var binding: FragmentAdminLoginBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.buttonLoginAdmin.setOnClickListener {
                findNavController().navigate(AdminLoginFragmentDirections.logToDashboard())
            }
            bindingNotNull.tvForgotPasswordAdmin.setOnClickListener {
                findNavController().navigate(AdminLoginFragmentDirections.logToForgettpass())
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
