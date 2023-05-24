
package com.icare.icare.screens

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.databinding.ViewCellPatientsListBinding
import com.icare.icare.generics.BaseRecyclerViewAdapter
import com.icare.icare.models.PatientList

class PatientListAdapter(
    val recyclerView: RecyclerView,
    val context: Context,
    val onItemClick: (position: Int) -> Unit
) : BaseRecyclerViewAdapter<PatientList, PatientListAdapter.ViewHolder>(
    recyclerView
) {
    override fun createViewHolder(
        viewGroup: ViewGroup,
        viewType: Int,
        layoutInflater: LayoutInflater
    ): ViewHolder {
        val binding = ViewCellPatientsListBinding.inflate(layoutInflater, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun bindViewHolder(
        viewHolder: ViewHolder,
        position: Int,
        item: PatientList
    ) {
        val binding = viewHolder.binding
        binding.tvPatientNameRecord.text = item.patientname

        binding.tvOpenRecord.setOnClickListener {
            onItemClick.invoke(position)
        }
    }

    class ViewHolder(val binding: ViewCellPatientsListBinding) : RecyclerView.ViewHolder(binding.root)
}
