package com.icare.icare.screens

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.databinding.ViewCellUsersListBinding
import com.icare.icare.generics.BaseRecyclerViewAdapter
import com.icare.icare.models.UsersList
class UsersListAdapter(
    val recyclerView: RecyclerView,
    val context: Context,
    val onItemClick: (position: Int) -> Unit
) : BaseRecyclerViewAdapter<UsersList, UsersListAdapter.ViewHolder>(
    recyclerView
) {
    override fun createViewHolder(
        viewGroup: ViewGroup,
        viewType: Int,
        layoutInflater: LayoutInflater
    ): ViewHolder {
        return ViewHolder(
            ViewCellUsersListBinding.inflate(
                layoutInflater,
                viewGroup,
                false
            )
        )
    }

    override fun bindViewHolder(
        viewHolder: ViewHolder,
        position: Int,
        item: UsersList
    ) {
        val binding = viewHolder.binding
        binding.tvUserL.text = item.userL
        binding.tvGetUserL.text = item.getuserL

        binding.tvViewUsers.setOnClickListener {
            onItemClick.invoke(position)
        }
    }

    class ViewHolder(val binding: ViewCellUsersListBinding) : RecyclerView.ViewHolder(binding.root)
}
