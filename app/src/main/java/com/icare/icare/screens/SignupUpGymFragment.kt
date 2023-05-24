package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.icare.icare.databinding.FragmentSignupGymBinding
import com.icare.icare.lookup_data.Lookups

class SignupUpGymFragment : BaseFragment() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://icare2023.azurewebsites.net") // Replace with your backend URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    private var binding: FragmentSignupGymBinding? = null
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
        binding = FragmentSignupGymBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { bindingNotNull ->
            bindingNotNull.buttonsignup5.setOnClickListener {
                findNavController().navigate(SignupUpGymFragmentDirections.actionSignupUpGymFragmentToFinishregister())
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
}