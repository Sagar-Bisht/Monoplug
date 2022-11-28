package com.example.monoplug.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.UserProfileStoriesAdapter
import com.example.monoplug.databinding.FragmentUserProfileStoriesBinding
import com.example.monoplug.model.UserProfileStories


class UserProfileStoriesFragment : Fragment() {

    lateinit var binding: FragmentUserProfileStoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_user_profile_stories,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myAdapter = UserProfileStoriesAdapter(getList())
        binding.recViewStories.layoutManager =
            GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
        binding.recViewStories.adapter = myAdapter

    }

    fun getList(): List<UserProfileStories> {
        var list = mutableListOf<UserProfileStories>()
        for (i in 1..3) {
            list.add(UserProfileStories(R.drawable.user_img))
        }
        return list
    }

}