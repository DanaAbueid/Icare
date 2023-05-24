


package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentNutriDashboardBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NutriDashboardFragment : Base2Fragment() {

    private var binding: FragmentNutriDashboardBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNutriDashboardBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.button.setOnClickListener {
                findNavController().navigate(NutriDashboardFragmentDirections.dashboardToNewNmainpage())
            }
            bindingNotNull.button3.setOnClickListener {
                findNavController().navigate(NutriDashboardFragmentDirections.dashboardToInfo())
            }
            bindingNotNull.button4.setOnClickListener {
                findNavController().navigate(NutriDashboardFragmentDirections.dashboardTOPATIENTS())
            }
            bindingNotNull.button5.setOnClickListener {
                findNavController().navigate(NutriDashboardFragmentDirections.dashboardToReports())
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}