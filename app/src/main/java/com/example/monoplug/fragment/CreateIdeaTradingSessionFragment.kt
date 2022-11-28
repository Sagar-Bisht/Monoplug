package com.example.monoplug.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.databinding.FragmentCreateIdeaTradingSessionBinding
import java.util.*


class CreateIdeaTradingSessionFragment : Fragment()  ,  DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    var day =0
    var month=0
    var year =0
    var hour=0
    var minute = 0
    var sday =0
    var smonth=0
    var syear =0
    var shour=0
    var sminute = 0

    lateinit var binding : FragmentCreateIdeaTradingSessionBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_idea_trading_session, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.root.setOnClickListener {
            findNavController().navigate(R.id.liveFragment)
        }
        pickDate()

        binding.etIdeaTrading.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                val length: Int =  binding.etIdeaTrading.length()
                val convert = length.toString()
                binding.tv0.text = convert


            }
        })
    }
    private fun getDateCalender(){
        val cal: Calendar = Calendar.getInstance()
        day=cal.get(Calendar.DAY_OF_MONTH)
        month=cal.get(Calendar.MONTH)
        year=cal.get(Calendar.YEAR)
        hour=cal.get(Calendar.HOUR)
        minute=cal.get(Calendar.MINUTE)
    }
    private fun pickDate(){
        binding.etDateTime.et.setOnClickListener {
            getDateCalender()
            DatePickerDialog(requireContext(),this,year,month,day).show()

        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        sday=dayOfMonth
        smonth=month+1
        syear=year
        getDateCalender()
        TimePickerDialog(requireContext(),this,hour,minute,true).show()
    }

    override fun onTimeSet(p0: TimePicker?, hoursOfDay: Int, minutes: Int) {
        val AM_PM : String
        AM_PM = if(hoursOfDay<12){
            "AM"
        }else{
            "PM"
        }
        shour= hoursOfDay
        sminute=minutes
        binding.etDateTime.et.text="$sday/$smonth/$syear  $shour:$sminute $AM_PM"
    }
}