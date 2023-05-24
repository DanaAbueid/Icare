
package com.icare.icare.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.CalendarView
import java.util.Calendar
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.icare.icare.R
import androidx.core.content.ContextCompat
import com.icare.icare.databinding.FragmentBookAppointmentBinding
class BookAppointmentFragment : BaseFragment() {

    private var binding: FragmentBookAppointmentBinding? = null

    override fun isLoggedin(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookAppointmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get a reference to the TimePicker view
        val timePicker = binding?.timePickerAppointment

        // Set the time picker to 24-hour mode
        timePicker?.setIs24HourView(true)

        // Set the onTimeChangedListener to round the minutes to zero
        timePicker?.setOnTimeChangedListener { _, hourOfDay, minute ->
            if (minute != 0) {
                timePicker?.minute = 0
            }
        }

        // Get a reference to the CalendarView view
        val calendarView = binding?.appointmentCalender

        // Set the minimum date to today's date
        calendarView?.minDate = System.currentTimeMillis()

        // Set the cell text color and size
        calendarView?.setDateTextAppearance(R.style.CalendarCell)
        // Set the onDateChangeListener to allow selection of present or future dates only
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val currentDate = Calendar.getInstance()
            val selectedDate = Calendar.getInstance().apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, month)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }

            if (selectedDate.before(currentDate)) {
                // Past dates
                view.setDateTextAppearance(R.style.CalendarCell_PastDate)
            } else {
                // Future dates
                view.setDateTextAppearance(R.style.CalendarCell_FutureDate)
            }
        }

        // Navigate to the PaymentFragment when the "Next" button is clicked
        binding?.nextToPayment?.setOnClickListener {
            findNavController().navigate(BookAppointmentFragmentDirections.actionBookAppointmentFragmentToPaymentFragment())
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
