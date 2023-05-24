package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentNewNutritionBinding
import com.icare.icare.lookup_data.Lookups

class NewNutrition : BaseFragment() {

    private var binding: FragmentNewNutritionBinding? = null

    override fun isLoggedin(): Boolean = false
    private val countries by lazy {
        context?.let { it1 ->
            Lookups(it1).getCountries()
        } ?: emptyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewNutritionBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.buttonsignup4.setOnClickListener {
                findNavController().navigate(NewNutritionDirections.actionSignupUpnewFragmentToFinishregister())

            }
            fillCountries()
        }
    }
    private fun fillCountries() {
        context?.let { it1 ->
            binding?.let { it2 ->
                val adapter = ArrayAdapter<String>(
                    it1,
                    android.R.layout.simple_spinner_item,
                    countries
                )
                it2.mactvCountry.setAdapter(adapter)
                it2.mactvCountry.setOnItemClickListener { adapterView, view, i, l ->
                    fillCities(countries[i])
                }
            }
        }
    }

    private fun fillCities(country: String) {
        context?.let { it1 ->
            binding?.let { it2 ->
                val cities = Lookups(it1).getCities(country)
                val adapter = ArrayAdapter<String>(
                    it1,
                    android.R.layout.simple_spinner_item,
                    cities
                )
                it2.mactvCity.setAdapter(adapter)
                it2.mactvCity.setOnItemClickListener { adapterView, view, i, l ->

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
