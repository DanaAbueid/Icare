package com.icare.icare.screens

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.icare.icare.MainActivity
import com.icare.icare.R
import com.icare.icare.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {



    private var binding: FragmentLoginBinding? = null
    private var selectedUserType: UserType = UserType.RegularUser
    override fun isLoggedin(): Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }
    enum class UserType {
        Patient,
        Nutritionist,
        Restaurant,
        RegularUser
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.radioGroup.setOnCheckedChangeListener { _, checkedId ->
                selectedUserType = when (checkedId) {
                    R.id.radioButtonPatient -> UserType.Patient
                    R.id.radioButtonNutr -> UserType.Nutritionist
                    R.id.radioButtonResta-> UserType.Restaurant
                    // Add cases for other user types as needed
                    else -> UserType.RegularUser
                }
            }
            bindingNotNull.tvCreateAccount.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignupUpUserFragment())
            }
            bindingNotNull.tvBecomePartner.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToBecomePartnerFragment())
            }
            bindingNotNull.buttonLogin.setOnClickListener {
                val action = when (selectedUserType) {
                    UserType.Patient -> LoginFragmentDirections.actionLoginFragmentToUserMyActivityFragment()
                    UserType.Nutritionist -> LoginFragmentDirections.actionLoginFragmentToNutretion()
                    UserType.Restaurant -> LoginFragmentDirections.texting()
                    else -> null
                }
                action?.let {

                    findNavController().navigate(it)
                }


            }

            bindingNotNull.tvForgotPassword.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment())
            }

            bindingNotNull.tvAdminLogin.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.adminlogin2())
            }

            }
        }
    }
