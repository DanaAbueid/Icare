
package com.icare.icare

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import com.icare.icare.R.id.nav_bar_item_nutrient
import androidx.navigation.findNavController
import com.icare.icare.databinding.ActivityNutritionistBinding
import com.icare.icare.databinding.ViewMenuItemNutritionBinding


class NutritionistActivity : AppCompatActivity() {
    private var binding: ActivityNutritionistBinding? = null
    private var selectedItemId = R.id.nav_bar_item_nutrient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNutritionistBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.dlMain?.openDrawer(Gravity.LEFT)
        binding?.dlMain?.closeDrawer(Gravity.LEFT)
        UserSession.defaultMenu = R.menu.menu_nutrition_bottom


    }

    fun isLoggedIn(state: Boolean) {
        binding?.nvMain?.isEnabled = state
        binding?.bottomNavigation?.visibility = View.VISIBLE.takeIf { state } ?: View.GONE
        if (state) {
            setBottomNav()
            setMenu()
        }
    }

    private fun setBottomNav() {
        UserSession.defaultMenu?.let {
            if (binding?.bottomNavigation?.menu?.isEmpty() == true) {
                binding?.bottomNavigation?.menu?.clear()
                binding?.bottomNavigation?.inflateMenu(it)
            }
            binding?.bottomNavigation?.setSelectedItemId(selectedItemId)
            binding?.bottomNavigation?.setOnItemSelectedListener {
                matchIdToFragment(it.itemId)?.let { idNotNull ->
                    selectedItemId = it.itemId
                    navigate(idNotNull)
                }
                true
            }
        }
    }

    private fun setMenu() {
        binding?.bottomNavigation?.menu?.let { menu ->
            binding?.clMenu?.llItems?.removeAllViews()
            menu.forEach {
                val itemBinding = ViewMenuItemNutritionBinding.inflate(layoutInflater)
                itemBinding.ivLogo.setImageDrawable(it.icon)
                itemBinding.tvTitle.text = it.title

                itemBinding.root.setOnClickListener { view ->
                    toggleSideMenu(false)
                    matchIdToFragment(it.itemId)?.let { idNotNull ->
                        selectedItemId = it.itemId
                        navigate(idNotNull)
                    }
                }
                if (it.itemId == selectedItemId) {
                    itemBinding.tvTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.light_green
                        )
                    )
                    itemBinding.ivLogo.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.light_green
                        )
                    )
                    itemBinding.root.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.semi_transparent_light_green
                        )
                    )
                }
                binding?.clMenu?.llItems?.addView(itemBinding.root)
            }


        }
    }

    private fun matchIdToFragment(id: Int): Int? {
        if (id == R.id.nav_bar_item_patient_record)
            return R.id.nutri_Records
        else if (id == R.id.nav_bar_item_nutrient)
            return R.id.Nutrition_Info_Fragment
        else if (id == R.id.nav_bar_item_reportsN)
            return R.id.nu_view_nreports
        return null
    }

    private fun navigate(@IdRes fragId: Int) {

        if (isFragmentInBackStack(fragId))
            findNavController(R.id.nav_host_fragment).popBackStack(fragId, false)
        else
            findNavController(R.id.nav_host_fragment).navigate(fragId)
    }

    private fun isFragmentInBackStack(destinationId: Int) =
        try {
            findNavController(R.id.nav_host_fragment).getBackStackEntry(destinationId)
            true
        } catch (e: Exception) {
            false
        }

    fun toggleSideMenu(state: Boolean) {
        if (state)
            binding?.dlMain?.openDrawer(Gravity.LEFT)
        else
            binding?.dlMain?.closeDrawer(Gravity.LEFT)
    }
}