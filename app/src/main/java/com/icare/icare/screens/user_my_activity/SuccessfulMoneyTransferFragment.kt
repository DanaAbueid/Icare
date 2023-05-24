
package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentSuccessfulMoneyTransferBinding



class SuccessfulMoneyTransferFragment : BaseFragment() {

    private var binding: FragmentSuccessfulMoneyTransferBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuccessfulMoneyTransferBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.donePayment.setOnClickListener {
                findNavController().navigate(SuccessfulMoneyTransferFragmentDirections.actionSuccessfullMoneyTransferToMainactivity())
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
