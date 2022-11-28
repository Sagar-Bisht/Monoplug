package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.ArtistProfilePostAdapter
import com.example.monoplug.databinding.FragmentArtistProfilePostBinding
import com.example.monoplug.model.ArtistProfilePost


class ArtistProfilePostFragment : Fragment() {


    lateinit var binding : FragmentArtistProfilePostBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_artist_profile_post, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var myAdapter = ArtistProfilePostAdapter(getList())
        binding.recViewPost.layoutManager=
            GridLayoutManager(requireContext(),3)
        binding.recViewPost.adapter=myAdapter
    }
    fun getList() : List<ArtistProfilePost>{
        var list = mutableListOf<ArtistProfilePost>()
        for(i in 1..3){
            list.add(ArtistProfilePost(R.drawable.user_img))
        }
        return list
    }
}