
package com.icare.icare.screens
import com.icare.icare.screens.UserReportAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.R
import com.icare.icare.databinding.FragmentAdminReportListBinding
import com.icare.icare.models.ReportsList
import com.icare.icare.screens.BaseFragment
import kotlinx.android.synthetic.main.view_cell_reports_list.*


class AdminReportListFragment  : Base2Fragment() {
    private var binding: FragmentAdminReportListBinding? = null
    override fun isLoggedin(): Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminReportListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewToolbar?.ivMenu?.visibility = View.VISIBLE
        binding?.viewToolbar?.ivMenu?.setOnClickListener {
            toggleSideMenu(true)
        }

        val UserReportAdapter = activity?.let {
            binding?.rvReportList?.let { it1 ->
                UserReportAdapter(
                    it1, it
                )
            }
        }
        val ReportsList = listOf<ReportsList>(
            ReportsList("User","Sara","dana","Reported User","i have a problem with the application","Status: Not Resolved"),
            ReportsList("User","Dana","dana","Reported User","i have a problem with the application","Status: Not Resolved"),
            ReportsList("User","Dana","dana","Reported User","i have a problem with the application","Status: Not Resolved"),
            ReportsList("User","Dana","dana","Reported User","i have a problem with the application","Status: Not Resolved"),


        )
        val dividerItemDecoration = DividerItemDecoration(
            binding?.rvReportList?.context,
            RecyclerView.VERTICAL
        )
        context?.let {
            ContextCompat.getDrawable(it, R.drawable.divider)
                ?.let { dividerItemDecoration.setDrawable(it) }
        }
        UserReportAdapter?.addItemDecoration(dividerItemDecoration)
        UserReportAdapter?.addAll(ReportsList)?.refresh()
    }


}