
package com.icare.icare.screens
import com.icare.icare.screens.RegistListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.R
import com.icare.icare.databinding.FragmentAdminRegistListBinding
import com.icare.icare.models.RegisList
import com.icare.icare.screens.BaseFragment
import kotlinx.android.synthetic.main.view_cell_reports_list.*

class AdminRegistListFragment : Base2Fragment() {
    private var binding: FragmentAdminRegistListBinding? = null

    override fun isLoggedin(): Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminRegistListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewToolbar?.ivMenu?.visibility = View.VISIBLE
        binding?.viewToolbar?.ivMenu?.setOnClickListener {
            toggleSideMenu(true)
        }

        val registListAdapter = activity?.let {
            binding?.rvNewusersList?.let { it1 ->
                RegistListAdapter(
                    it1, it
                ) { position ->
                    // Button click listener for each item
                    val action = AdminRegistListFragmentDirections.listToInfo(position)
                    findNavController().navigate(action)
                }
            }
        }

        val registrationList = listOf<RegisList>(
            RegisList("User:", "John Doe"),
            RegisList("User:", "John Doe"),
            RegisList("User:", "John Doe"),
            RegisList("User:", "John Doe")
        )

        val dividerItemDecoration = DividerItemDecoration(
            binding?.rvNewusersList?.context,
            RecyclerView.VERTICAL
        )
        context?.let {
            ContextCompat.getDrawable(it, R.drawable.divider)
                ?.let { dividerItemDecoration.setDrawable(it) }
        }

        registListAdapter?.addItemDecoration(dividerItemDecoration)
        registListAdapter?.addAll(registrationList)?.refresh()
    }
}
