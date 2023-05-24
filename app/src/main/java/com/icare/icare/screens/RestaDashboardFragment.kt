

package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentRestaDashboardBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaDashboardFragment : Base2Fragment() {

    private var binding: FragmentRestaDashboardBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestaDashboardBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.button.setOnClickListener {
                findNavController().navigate(RestaDashboardFragmentDirections.dashboardToNewRmainpage())
            }
            bindingNotNull.button3.setOnClickListener {
                findNavController().navigate(RestaDashboardFragmentDirections.dashboardToRinfo())
            }

            bindingNotNull.button5.setOnClickListener {
                findNavController().navigate(RestaDashboardFragmentDirections.dashboardToRreports())
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
