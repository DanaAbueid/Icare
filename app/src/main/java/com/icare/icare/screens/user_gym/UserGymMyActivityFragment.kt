package com.icare.icare.screens.user_gym

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.databinding.FragmentUserGymMyActivityBinding
import com.icare.icare.screens.BookAppointmentFragmentDirections
import com.icare.icare.screens.LoginFragmentDirections

class UserGymMyActivityFragment : UserGymFragment() {
    private var binding: FragmentUserGymMyActivityBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserGymMyActivityBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.calcYourBmiForm.setOnClickListener {
                findNavController().navigate(UserGymMyActivityFragmentDirections.dashboardToBmicalc())
            }
            bindingNotNull.buttonLink.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignupUpUserFragment())
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
