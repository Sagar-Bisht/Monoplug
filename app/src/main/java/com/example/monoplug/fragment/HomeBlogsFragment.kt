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
import com.example.monoplug.adapter.ClickListener3
import com.example.monoplug.adapter.HomeBlogsAdapter
import com.example.monoplug.databinding.FragmentHomeBlogsBinding
import com.example.monoplug.model.HomeBlogs


class HomeBlogsFragment : Fragment() , ClickListener3 {

    lateinit var binding : FragmentHomeBlogsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_blogs, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = HomeBlogsAdapter(getList(),this)
        binding.recViewBlogs.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewBlogs.adapter = myAdapter

    }
    fun getList() : List<HomeBlogs> {
        var list = mutableListOf<HomeBlogs>()
        for (i in 1..10) {
            list.add(HomeBlogs(R.drawable.blogs_img,
            "Job of Dancers",
            "Video URL: www.google.com",
            "Lorem Ipsum is simply dummy text of the printing and typesetting " +
                    "industry. Lorem Ipsum has been the industry's standard" +
                    " dummy text ever since the 1500s, when an unknown printer to" +
                    "ok a galley of type and scrambled it to make a type specimen book."))
        }
        return list
        }

    override fun onHomeBlogClick() {
        findNavController().navigate(R.id.blogDetailsFragment)
    }
}