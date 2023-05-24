
package com.icare.icare.screens
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import com.icare.icare.databinding.FragmentCalculateBmiBinding

class CalculateBmiFragment : Fragment() {
    private var binding: FragmentCalculateBmiBinding? = null

    private lateinit var currentHeightTextView: TextView
    private lateinit var currentWeightTextView: TextView
    private lateinit var currentAgeTextView: TextView
    private lateinit var incrementAgeImageView: ImageView
    private lateinit var decrementAgeImageView: ImageView
    private lateinit var incrementWeightImageView: ImageView
    private lateinit var decrementWeightImageView: ImageView
    private lateinit var heightSeekBar: SeekBar
    private lateinit var calculateBmiButton: Button
    private lateinit var maleRelativeLayout: RelativeLayout
    private lateinit var femaleRelativeLayout: RelativeLayout

    private var intWeight = 55
    private var intAge = 22
    private var currentProgress = 170
    private var typeOfUser = "0"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBmiBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentHeightTextView = binding?.currentheight!!
        currentWeightTextView = binding?.currentweight!!
        currentAgeTextView = binding?.currentage!!
        incrementAgeImageView = binding?.incrementage!!
        decrementAgeImageView = binding?.decrementage!!
        incrementWeightImageView = binding?.incremetweight!!
        decrementWeightImageView = binding?.decrementweight!!
        heightSeekBar = binding?.seekbarforheight!!
        calculateBmiButton = binding?.calculatebmi!!
        maleRelativeLayout = binding?.male!!
        femaleRelativeLayout = binding?.female!!

        incrementAgeImageView.setOnClickListener {
            intAge += 1
            currentAgeTextView.text = intAge.toString()
        }

        decrementAgeImageView.setOnClickListener {
            intAge -= 1
            currentAgeTextView.text = intAge.toString()
        }

        incrementWeightImageView.setOnClickListener {
            intWeight += 1
            currentWeightTextView.text = intWeight.toString()
        }

        decrementWeightImageView.setOnClickListener {
            intWeight -= 1
            currentWeightTextView.text = intWeight.toString()
        }

        heightSeekBar.apply {
            max = 300
            progress = currentProgress
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    currentProgress = progress
                    currentHeightTextView.text = currentProgress.toString()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })
        }

        maleRelativeLayout.setOnClickListener {
            maleRelativeLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.malefemalefocus)
            femaleRelativeLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.malefemalenotfocus)
            typeOfUser = "Male"
        }

        femaleRelativeLayout.setOnClickListener {
            femaleRelativeLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.malefemalefocus)
            maleRelativeLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.malefemalenotfocus)
            typeOfUser = "Female"
        }

        calculateBmiButton.setOnClickListener {
            if (typeOfUser == "0") {
                Toast.makeText(requireContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show()
            } else if (currentProgress == 0) {
                Toast.makeText(requireContext(), "Select Your Height First", Toast.LENGTH_SHORT).show()
            } else if (intAge == 0 || intAge < 0) {
                Toast.makeText(requireContext(), "Age is Incorrect", Toast.LENGTH_SHORT).show()
            } else if (intWeight == 0 || intWeight < 0) {
                Toast.makeText(requireContext(), "Weight Is Incorrect", Toast.LENGTH_SHORT).show()
            } else {
                val action = CalculateBmiFragmentDirections.actionCalculateBmiFragmentToBmiresultFragment(
                    typeOfUser,
                    currentProgress.toString(),
                    intWeight.toString(),
                    intAge.toString()
                )
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}






