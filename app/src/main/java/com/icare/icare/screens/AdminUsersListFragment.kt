package com.icare.icare.screens
import com.icare.icare.screens.UsersListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.R
import com.icare.icare.databinding.FragmentAdminUsersListBinding
import com.icare.icare.models.UsersList
import com.icare.icare.screens.BaseFragment

class AdminUsersListFragment : Base2Fragment() {
    private var binding: FragmentAdminUsersListBinding? = null

    override fun isLoggedin(): Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminUsersListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewToolbar?.ivMenu?.visibility = View.VISIBLE
        binding?.viewToolbar?.ivMenu?.setOnClickListener {
            toggleSideMenu(true)
        }

        val usersListAdapter = activity?.let {
            binding?.rvUsersList?.let { it1 ->
                UsersListAdapter(it1, it) { position ->
                    // Button click listener for each item
                    val action = AdminUsersListFragmentDirections.usersToInfo(position)
                    findNavController().navigate(action)
                }
            }
        }

        val usersList = listOf<UsersList>(
            UsersList("User:", "John Doe"),
            UsersList("User", "John Doe"),
            UsersList("User", "John Doe"),
            UsersList("User", "John Doe"),
            UsersList("User", "John Doe")
        )

        val dividerItemDecoration = DividerItemDecoration(
            binding?.rvUsersList?.context,
            RecyclerView.VERTICAL
        )
        context?.let {
            ContextCompat.getDrawable(it, R.drawable.divider)
                ?.let { dividerItemDecoration.setDrawable(it) }
        }

        usersListAdapter?.addItemDecoration(dividerItemDecoration)
        usersListAdapter?.addAll(usersList)?.refresh()
    }
}
