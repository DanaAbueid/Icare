package com.icare.icare.screens
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentBmiResultBinding

class BmiResultFragment : Fragment() {

    private lateinit var binding: FragmentBmiResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBmiResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the action bar
        requireActivity().title = "Result"
        val colorDrawable = ColorDrawable(Color.parseColor("#1E1D1D"))
        requireActivity().actionBar?.setBackgroundDrawable(colorDrawable)
        requireActivity().actionBar?.elevation = 0f

        // Get the data from the previous fragment
        val height = arguments?.getString("height")
        val weight = arguments?.getString("weight")

        // Calculate the BMI and determine the category
        val intheight = height?.toFloatOrNull()?.div(100) ?: 0f
        val intweight = weight?.toFloatOrNull() ?: 0f
        val intbmi = intweight / (intheight * intheight)
        val mbmi = String.format("%.1f", intbmi)
        val category = when {
            intbmi < 16 -> "Severe Thinness"
            intbmi < 16.9 -> "Moderate Thinness"
            intbmi < 18.4 -> "Mild Thinness"
            intbmi < 24.9 -> "Normal"
            intbmi < 29.9 -> "Overweight"
            intbmi < 34.9 -> "Obese Class I"
            else -> "Obese Class II"
        }

        // Display the data in the UI
        binding.bmidisplay.text = mbmi
        binding.bmicategorydispaly.text = category
        binding.genderdisplay.text = arguments?.getString("gender")

        binding.gotomain.setOnClickListener {
            findNavController().navigate(R.id.action_bmiresultFragment_to_dashboard)
        }

        when (category) {
            "Severe Thinness" -> {
                binding.contentlayout.setBackgroundColor(Color.RED)
                binding.imageview.setImageResource(R.drawable.crosss)
            }
            "Moderate Thinness", "Mild Thinness", "Overweight", "Obese Class I" -> {
                binding.contentlayout.setBackgroundColor(
                    resources.getColor(R.color.begie, requireActivity().theme)
                )
                binding.imageview.setImageResource(R.drawable.warning)
            }
            else -> {
                binding.imageview.setImageResource(R.drawable.ok)
            }
        }
    }


}
