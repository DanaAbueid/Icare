package com.icare.icare.screens.user_nutrition_centers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.icare.icare.R
import com.icare.icare.databinding.FragmentUserNutritionCentersBinding
import com.icare.icare.models.Center
import com.icare.icare.screens.BaseFragment

open class UserNutritionCentersFragment : BaseFragment() {
    private var binding: FragmentUserNutritionCentersBinding? = null
    override fun isLoggedin(): Boolean = true


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserNutritionCentersBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let { bindingNotNull ->
            bindingNotNull.viewToolbar.ivMenu.visibility = View.VISIBLE
            bindingNotNull.viewToolbar.ivMenu.setOnClickListener {
                toggleSideMenu(true)
            }

            val userNutritionCentersAdapter = activity?.let {
                UserNutritionCentersAdapter(
                    bindingNotNull.rvHealthFood,
                    it
                ) { position ->
                    // Button click listener for each item
                    val action = UserNutritionCentersFragmentDirections.listToBook(position)
                    findNavController().navigate(action)
                }
            }


            val nutritionCentersList = listOf<Center>(
                Center("Test 1", R.drawable.doctor1, 5f, "open until 5", "Amman Jordan"),
                Center("Test 2", R.drawable.doctor2, 4f, "open until 4", "Amman Jordan"),
                Center("Test 3", R.drawable.doctor3, 3f, "open until 2", "Amman Jordan"),
                Center("Test 4", R.drawable.doctor4, 2f, "open until 5", "Amman Jordan"),
                Center("Test 5", R.drawable.doctor5, 5f, "open until 6", "Amman Jordan"),
                Center("Test 6", R.drawable.doctor6, 3f, "open until 5", "Amman Jordan"),
                Center("Test 7", R.drawable.doctor7, 1f, "open at 9", "Amman Jordan"),
            )
            val dividerItemDecoration = DividerItemDecoration(
                bindingNotNull.rvHealthFood.context,
                RecyclerView.VERTICAL
            )
            context?.let {
                ContextCompat.getDrawable(it, R.drawable.divider)
                    ?.let { dividerItemDecoration.setDrawable(it) }
            }
            userNutritionCentersAdapter?.addItemDecoration(dividerItemDecoration)
            userNutritionCentersAdapter?.addAll(nutritionCentersList)?.refresh()
        }
    }

}