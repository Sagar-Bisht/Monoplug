package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.HomeNewsAdapter
import com.example.monoplug.databinding.FragmentHomeNewsBinding
import com.example.monoplug.model.HomeNews

class HomeNewsFragment : Fragment(), HomeNewsAdapter.ClickListener2 {

    lateinit var binding : FragmentHomeNewsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding =DataBindingUtil.inflate(inflater,R.layout.fragment_home_news, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = HomeNewsAdapter(getList(),this)
        binding.recViewNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewNews.adapter = myAdapter
    }
    fun getList() : List<HomeNews>{
        var list = mutableListOf<HomeNews>()
        for(i in 1..10) {
            list.add(HomeNews("Job Of Dancers",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                            " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
                )
            )
        }
        return list
    }

    override fun onHomeNewsClick() {
        findNavController().navigate(R.id.newsDetailsFragment)
    }
}