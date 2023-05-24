
package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icare.icare.databinding.FragmentRestaurentInfoBinding
import com.icare.icare.screens.BaseFragment

class RestaurentInfoFragment : Base2Fragment() {
    private var binding: FragmentRestaurentInfoBinding? = null

    override fun isLoggedin() = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestaurentInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let { bindingNotNull ->
            bindingNotNull.viewToolbar.ivMenu.visibility = View.VISIBLE
            bindingNotNull.viewToolbar.ivMenu.setOnClickListener {
                toggleSideMenu(true)
            }
        }
    }
}
