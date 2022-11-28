package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.UserProfilePostAdapter
import com.example.monoplug.databinding.FragmentUserProfilePostBinding
import com.example.monoplug.model.UserProfilePost


class UserProfilePostFragment : Fragment() {

    lateinit var binding : FragmentUserProfilePostBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_profile_post, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myAdapter = UserProfilePostAdapter(getList())
        binding.recViewPost.layoutManager=GridLayoutManager(requireContext(),3 , GridLayoutManager.VERTICAL,false)
        binding.recViewPost.adapter=myAdapter

    }

    fun getList() : List<UserProfilePost>{
        var list = mutableListOf<UserProfilePost>()
        for(i in 1..9) {
            list.add(UserProfilePost(R.drawable.user_img))
        }
        return list
    }
}