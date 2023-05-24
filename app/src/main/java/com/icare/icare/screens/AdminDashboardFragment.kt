


package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentAdminDashboardBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AdminDashboardFragment : Base2Fragment() {

    private var binding: FragmentAdminDashboardBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminDashboardBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.button.setOnClickListener {
                findNavController().navigate(AdminDashboardFragmentDirections.dashboardToNewMainpage())
            }
            bindingNotNull.button3.setOnClickListener {
                findNavController().navigate(AdminDashboardFragmentDirections.dashboardToNewUsers())
            }
            bindingNotNull.button4.setOnClickListener {
                findNavController().navigate(AdminDashboardFragmentDirections.dashboardToUsers())
            }
            bindingNotNull.button5.setOnClickListener {
                findNavController().navigate(AdminDashboardFragmentDirections.dashboardToReports())
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
