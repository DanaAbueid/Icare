
package com.icare.icare.screens

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.databinding.ViewCellReviewedUsersBinding
import com.icare.icare.generics.BaseRecyclerViewAdapter
import com.icare.icare.models.RegisList
class RegistListAdapter(
    val recyclerView: RecyclerView,
    val context: Context,
    val onItemClick: (position: Int) -> Unit
) : BaseRecyclerViewAdapter<RegisList, RegistListAdapter.ViewHolder>(
    recyclerView
) {
    override fun createViewHolder(
        viewGroup: ViewGroup,
        viewType: Int,
        layoutInflater: LayoutInflater
    ): ViewHolder {
        return ViewHolder(
            ViewCellReviewedUsersBinding.inflate(
                layoutInflater,
                viewGroup,
                false
            )
        )
    }

    override fun bindViewHolder(
        viewHolder: ViewHolder,
        position: Int,
        item: RegisList
    ) {
        with(viewHolder.binding) {
            tvNewuser.text = item.Reguser
            tvGetNewuser.text = item.getReguser

            tvViewNUsers.setOnClickListener {
                onItemClick.invoke(position)
            }
        }
    }

    class ViewHolder(val binding: ViewCellReviewedUsersBinding) : RecyclerView.ViewHolder(binding.root)
}
