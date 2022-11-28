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
import com.example.monoplug.adapter.SocialAdapter
import com.example.monoplug.databinding.FragmentSocialBinding
import com.example.monoplug.model.Social
import com.example.monoplug.model.SocialStory


class SocialFragment : Fragment() , SocialAdapter.SocialInterface {

    lateinit var binding : FragmentSocialBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_social, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var socialAdapter = SocialAdapter(getList(),this)
        binding.recViewSocial.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewSocial.adapter = socialAdapter


//        var storyAdapter = SocialStoryAdapter(storyList())
//        binding.recViewStory.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
//        binding.recViewStory.adapter=storyAdapter


        binding.floatingBtn.setOnClickListener {
            findNavController().navigate(R.id.createPostFragment)
        }

        binding.imgStory.setOnClickListener {
            findNavController().navigate(R.id.createStoryFragment)
        }
        binding.imgPlus.setOnClickListener {
            findNavController().navigate(R.id.createStoryFragment)
        }
        binding.imgStory2.setOnClickListener {
            findNavController().navigate(R.id.userStoryFragment)
        }
        binding.imgStory3.setOnClickListener {
            findNavController().navigate(R.id.userStoryFragment)
        }
        binding.imgStory4.setOnClickListener {
            findNavController().navigate(R.id.userStoryFragment)
        }
        binding.imgStory5.setOnClickListener {
            findNavController().navigate(R.id.userStoryFragment)
        }
        binding.imgStory6.setOnClickListener {
            findNavController().navigate(R.id.userStoryFragment)
        }

    }

    private fun getList() : List<Social>{
        var list = mutableListOf<Social>()
        for(i in 1..10) {
            list.add(
                Social(
                    R.drawable.img_round, R.drawable.social_big_img, R.drawable.social_s_img, R.drawable.social_s_img, R.drawable.social_s_img
                    ,"MJ96",
                    "27/01/2022 11:00 AM",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                            "when an unknown printer took a galley of type and scrambled it " +
                            "to make a type specimen book."))
        }
        return list
    }

    private fun storyList() : List<SocialStory>{
        var list = mutableListOf<SocialStory>()
        list.add(SocialStory(R.drawable.social_img,"Your Story"))
        for(i in 1..10) {
         list.add(SocialStory(R.drawable.social_img,"MJ96"))
        }
        return list
    }



    override fun onClick() {
       findNavController().navigate(R.id.userStoryFragment)
    }

    override fun onClickProfile() {
       findNavController().navigate(R.id.userProfileFragment)
    }

    override fun onClickPostDetails() {
        findNavController().navigate(R.id.postDetailsFragment)
    }
}