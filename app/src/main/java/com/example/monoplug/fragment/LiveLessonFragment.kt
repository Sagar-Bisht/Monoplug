package com.example.monoplug.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.LiveLessonAdapter
import com.example.monoplug.adapter.LiveTopViewAdapter
import com.example.monoplug.databinding.FragmentLiveLessonBinding
import com.example.monoplug.model.LiveLesson
import com.example.monoplug.model.LiveTopView


class LiveLessonFragment : Fragment()  , LiveLessonAdapter.BtnJoinClick {

    lateinit var binding: FragmentLiveLessonBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_live_lesson, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myAdapter1 = LiveTopViewAdapter(getList1())
        binding.recViewLesson1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recViewLesson1.adapter = myAdapter1

        var myAdapter2 = LiveLessonAdapter(getList2(),this)
        binding.recViewLesson2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewLesson2.adapter = myAdapter2
    }

    fun getList1(): List<LiveTopView> {
        var list = mutableListOf<LiveTopView>()
        list.add(LiveTopView(R.drawable.guitar, "Guitar"))
        list.add(LiveTopView(R.drawable.banjo, "Banjo"))
        list.add(LiveTopView(R.drawable.berimbau, "Berimbau"))
        list.add(LiveTopView(R.drawable.guitar, "Guitar"))
        list.add(LiveTopView(R.drawable.banjo, "Banjo"))
        list.add(LiveTopView(R.drawable.berimbau, "Berimbau"))
        list.add(LiveTopView(R.drawable.guitar, "Guitar"))
        list.add(LiveTopView(R.drawable.banjo, "Banjo"))
        list.add(LiveTopView(R.drawable.berimbau, "Berimbau"))
        return list
    }

    fun getList2(): List<LiveLesson> {
        var list = mutableListOf<LiveLesson>()
        for (i in 1..4) {
            list.add(
                LiveLesson(
                    "Guitar Lesson",
                    "25/01/2022 04:40 PM",
                    "Micheal"
                )
            )
        }
        return list
    }

    override fun onClick() {
        findNavController().navigate(R.id.liveTwoFragment)
    }
}