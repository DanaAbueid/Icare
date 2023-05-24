package com.icare.icare.screens.user_my_activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icare.icare.screens.BaseFragment
import com.icare.icare.databinding.FragmentUserMyInformationBinding

class UserMyInformationFragment : BaseFragment() {

    private var binding: FragmentUserMyInformationBinding? = null

    override fun isLoggedin(): Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserMyInformationBinding.inflate(inflater, container, false)
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
