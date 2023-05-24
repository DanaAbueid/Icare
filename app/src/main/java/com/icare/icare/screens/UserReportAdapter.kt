package com.icare.icare.screens

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.databinding.ViewCellReportsListBinding
import com.icare.icare.generics.BaseRecyclerViewAdapter
import com.icare.icare.models.ReportsList

class UserReportAdapter(
    val recyclerView: RecyclerView,
    val context: Context
) : BaseRecyclerViewAdapter<ReportsList, UserReportAdapter.ViewHolder>(
    recyclerView
) {
    override fun createViewHolder(
        viewGroup: ViewGroup,
        viewType: Int,
        layoutInflater: LayoutInflater
    ): ViewHolder {
        return ViewHolder(
            ViewCellReportsListBinding.inflate(
                layoutInflater,
                viewGroup,
                false
            )
        )
    }

    override fun bindViewHolder(
        viewHolder: ViewHolder,
        position: Int,
        item: ReportsList
    ) {
        with(viewHolder.binding) {
         tvUser.text=item.user
            tvReported.text=item.reported
            tvGetUser.text= item.getuser
            tvGetReported.text = item.getreported
            tvReportText.text = item.reptext
           tvStatus.text = item.status
        }
    }

    class ViewHolder(val binding: ViewCellReportsListBinding) : RecyclerView.ViewHolder(binding.root)

}