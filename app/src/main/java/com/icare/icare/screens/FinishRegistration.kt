

package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentFinishRegBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FinishRegistration : BaseFragment() {

    private var binding: FragmentFinishRegBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinishRegBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.buttonFinishReg.setOnClickListener {
                findNavController().navigate(FinishRegistrationDirections.finishRegistrationToLoginpage())
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
