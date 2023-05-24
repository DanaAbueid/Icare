package com.icare.icare.screens.user_my_activity

import com.icare.icare.screens.BaseFragment
import com.icare.icare.screens.user_my_activity.NutritionInfoFragmentDirections
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentNutritionInfoBinding


class NutritionInfoFragment : BaseFragment() {

    private var binding: FragmentNutritionInfoBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNutritionInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.nextToBookappoint.setOnClickListener {
                findNavController().navigate(NutritionInfoFragmentDirections.actionUserNutritionInfoFragmentToBookAppointment())
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
