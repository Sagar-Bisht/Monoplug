package com.example.monoplug.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.ArtistProfileStoriesAdapter
import com.example.monoplug.databinding.FragmentArtistProfileStoriesBinding
import com.example.monoplug.model.ArtistProfileStories


class ArtistProfileStoriesFragment : Fragment() {

    lateinit var binding: FragmentArtistProfileStoriesBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      binding = DataBindingUtil.inflate(inflater,R.layout.fragment_artist_profile_stories, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var myAdapter = ArtistProfileStoriesAdapter(getList())
        binding.recViewStories.layoutManager=
            GridLayoutManager(requireContext(),3)
        binding.recViewStories.adapter=myAdapter
    }
    fun getList() : List<ArtistProfileStories>{
        var list = mutableListOf<ArtistProfileStories>()
        for(i in 1..3){
            list.add(ArtistProfileStories(R.drawable.user_img))
        }
        return list
    }

}