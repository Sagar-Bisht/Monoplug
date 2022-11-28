package com.example.monoplug.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.databinding.FragmentJobDetails2Binding
import java.util.*


class JobDetails2Fragment : Fragment() ,  DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

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


    lateinit var binding: FragmentJobDetails2Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_job_details2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMarkJobAsDone.setOnClickListener{
            findNavController().navigate(R.id.myJobsFragment)
        }
        binding.btnRaiseDispute.root.setOnClickListener {
            findNavController().navigate(R.id.raiseDisputeFragment)
        }

        pickDate()
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
