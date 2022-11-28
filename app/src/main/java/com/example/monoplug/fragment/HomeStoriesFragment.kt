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
import com.example.monoplug.adapter.HomeStoriesAdapter
import com.example.monoplug.databinding.FragmentHomeStoriesBinding
import com.example.monoplug.model.HomeStories

class HomeStoriesFragment : Fragment() , HomeStoriesAdapter.ClickListener {

    lateinit var binding : FragmentHomeStoriesBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_stories, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = HomeStoriesAdapter(getList(),this)
        binding.recView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recView.adapter = myAdapter

    }

    fun getList() : List<HomeStories>{
        var list = mutableListOf<HomeStories>()
        for(i in 1..10) {
            list.add(
                HomeStories(
                    R.drawable.home_img,
                    R.drawable.home_img_one,
                    R.drawable.home_img_two,
                    R.drawable.home_img_two,
                    R.drawable.home_img_two,
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                            " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
                )
            )
        }
        return list
    }

    override fun onHomeStoryClick() {
       findNavController().navigate(R.id.storyDetailsFragment)
    }

}