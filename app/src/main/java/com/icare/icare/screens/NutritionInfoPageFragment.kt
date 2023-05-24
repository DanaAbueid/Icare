package com.icare.icare.screens

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.text.InputType
import androidx.fragment.app.Fragment
import com.icare.icare.databinding.FragmentNutritionInfoPageBinding
import java.util.*

class NutritionInfoPageFragment : Fragment() {
    private var binding: FragmentNutritionInfoPageBinding? = null
    private var startDatePicker: EditText? = null
    private var endDatePicker: EditText? = null
    private var startDate: Calendar = Calendar.getInstance()
    private var endDate: Calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNutritionInfoPageBinding.inflate(inflater, container, false)
        startDatePicker = binding?.startDatePicker
        endDatePicker = binding?.endDatePicker
        startDatePicker?.inputType = InputType.TYPE_NULL
        endDatePicker?.inputType = InputType.TYPE_NULL

        setupDatePickers(startDate, endDate)
        return binding?.root
    }

    private fun setupDatePickers(startDate: Calendar, endDate: Calendar) {
        // Set up start date picker
        binding?.startDatePicker?.setOnClickListener {
            showDatePicker(binding?.startDatePicker!!, startDate)
        }

        // Set up end date picker
        binding?.endDatePicker?.setOnClickListener {
            showDatePicker(binding?.endDatePicker!!, endDate)
        }
    }




    private fun showDatePicker(datePickerView: EditText, calendar: Calendar) {
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                calendar.set(year, monthOfYear, dayOfMonth)
                datePickerView.setText(getFormattedDate(calendar))
                checkDateValidity()
                datePickerView.clearFocus() // Hide the keyboard
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000 // Set min date to today
        datePickerDialog.show()
    }





    private fun checkDateValidity() {
        val currentDate = Calendar.getInstance()

        // Check if start date is in the past
        if (startDate.before(currentDate)) {
            startDate = currentDate.clone() as Calendar
            startDatePicker?.setText(getFormattedDate(startDate))
        }

        // Check if end date is before the start date
        if (endDate.before(startDate)) {
            endDate = startDate.clone() as Calendar
            endDatePicker?.setText(getFormattedDate(endDate))
        }
    }

    private fun getFormattedDate(calendar: Calendar): String {
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
        val year = calendar.get(Calendar.YEAR)
        return "$day $month $year"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
