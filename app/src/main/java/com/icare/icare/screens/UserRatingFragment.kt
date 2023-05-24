package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentUserRatingBinding

class UserRatingFragment : BaseFragment() {

    private var binding: FragmentUserRatingBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserRatingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.submitBtn.setOnClickListener {
                val rating = bindingNotNull.ratingBar.rating
                findNavController().navigate(UserRatingFragmentDirections.actionRateToDashboard())
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
