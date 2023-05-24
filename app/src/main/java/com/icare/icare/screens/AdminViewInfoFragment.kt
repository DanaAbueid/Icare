package com.icare.icare.screens

import com.icare.icare.screens.BaseFragment
import com.icare.icare.screens.user_my_activity.NutritionInfoFragmentDirections
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentAdminViewInfoBinding


class AdminViewInfoFragment : Base2Fragment() {

    private var binding: FragmentAdminViewInfoBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminViewInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
