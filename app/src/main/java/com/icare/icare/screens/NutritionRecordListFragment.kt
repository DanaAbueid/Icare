
package com.icare.icare.screens
import com.icare.icare.screens.PatientListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.R
import com.icare.icare.databinding.FragmentNutritionRecordListBinding
import com.icare.icare.models.PatientList
import com.icare.icare.screens.Base2Fragment
import kotlinx.android.synthetic.main.view_cell_reports_list.*

class NutritionRecordListFragment : Base2Fragment() {
    private var binding: FragmentNutritionRecordListBinding? = null

    override fun isLoggedin(): Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNutritionRecordListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewToolbar?.ivMenu?.visibility = View.VISIBLE
        binding?.viewToolbar?.ivMenu?.setOnClickListener {
            toggleSideMenu(true)
        }

        val patientListAdapter = activity?.let {
            binding?.rvPatientList?.let { it1 ->
                PatientListAdapter(
                    it1, it
                ) { position ->
                    // Button click listener for each item
                    val action = NutritionRecordListFragmentDirections.recordToPatient(position)
                    findNavController().navigate(action)
                }
            }
        }

        val patientsList = listOf<PatientList>(
            PatientList("John Doe"),
            PatientList("John Doe"),
            PatientList("John Doe"),
            PatientList("John Doe"),
            PatientList("John Doe"),
            PatientList("John Doe")
        )

        val dividerItemDecoration = DividerItemDecoration(
            binding?.rvPatientList?.context,
            RecyclerView.VERTICAL
        )
        context?.let {
            ContextCompat.getDrawable(it, R.drawable.divider)
                ?.let { drawable ->
                    dividerItemDecoration.setDrawable(drawable)
                }
        }

        patientListAdapter?.addItemDecoration(dividerItemDecoration)
        patientListAdapter?.addAll(patientsList)?.refresh()
    }
}
