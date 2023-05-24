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
import androidx.navigation.findNavController
import com.icare.icare.R.id.nav_bar_item_my_activity
import com.icare.icare.databinding.ActivityMainBinding
import com.icare.icare.databinding.ViewMenuItemBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var selectedItemId = nav_bar_item_my_activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.dlMain?.openDrawer(Gravity.LEFT)
        binding?.dlMain?.closeDrawer(Gravity.LEFT)
        UserSession.defaultMenu = R.menu.menu_user


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
                val itemBinding = ViewMenuItemBinding.inflate(layoutInflater)
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
        if (id == R.id.nav_bar_item_nutrition_centers)
            return R.id.userNutritionCentersFragment
        else if (id == R.id.nav_bar_item_my_activity)
            return R.id.userMyActivityFragment
        else if (id == R.id.nav_bar_item_health_food)
            return R.id.userHealthFoodFragment
        else if (id == R.id.nav_bar_item_myinfo_user)
            return R.id.usermyinfofragment
        else if (id == R.id.nav_bar_item_reports)
            return R.id.userReportFragment
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