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
import com.example.monoplug.adapter.SearchFragmentAdapter
import com.example.monoplug.databinding.FragmentSearchBinding
import com.example.monoplug.model.Search


class SearchFragment : Fragment() , SearchFragmentAdapter.SearchListenerClick {

    lateinit var binding : FragmentSearchBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var searchAdapter = SearchFragmentAdapter(getList(), this)
        binding.recViewSearch.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewSearch.adapter=searchAdapter

    }
    fun getList() : List<Search>{
        var list = mutableListOf<Search>()
        for(i in 1..6) {
            list.add(Search(R.drawable.img_round,"MJ96"))
        }
        return list
    }

    override fun viewProfileClick() {
       findNavController().navigate(R.id.userProfileFragment)
    }


}