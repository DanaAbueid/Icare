package com.icare.icare.screens

import androidx.fragment.app.Fragment
import com.icare.icare.MainActivity
import com.icare.icare.NutritionistActivity

abstract class Base2Fragment :  Fragment() {
    abstract fun isLoggedin(): Boolean

    override fun onResume() {
        super.onResume()
        activity?.let {
            if (it is NutritionistActivity) {
                it.isLoggedIn(isLoggedin())
            }
        }
    }

    fun toggleSideMenu(state: Boolean) {
        activity?.let { activityNotNull ->
            if (activityNotNull is NutritionistActivity)
                activityNotNull.toggleSideMenu(state)
        }
    }
}