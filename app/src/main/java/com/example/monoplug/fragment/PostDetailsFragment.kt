package com.example.monoplug.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.monoplug.R
import com.example.monoplug.adapter.VPagerAdapterForStoryDetails
import com.example.monoplug.databinding.FragmentPostDetailsBinding
import com.example.monoplug.model.ImageSlider

class PostDetailsFragment : Fragment() {

    lateinit var binding: FragmentPostDetailsBinding
    var clicked: Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_post_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgHeart.setOnClickListener {
            buttonSelector(it as ImageView)
        }

        binding.imgDislike.setOnClickListener {
            buttonSelector(it as ImageView)
        }

        binding.imgCircle.setOnClickListener {
            buttonSelector(it as ImageView)
        }

        var myAdapter = VPagerAdapterForStoryDetails(getList())
        binding.viewPager.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPager.adapter=myAdapter
        binding.indicator.setViewPager(binding.viewPager)

    }

    private fun buttonSelector(it: ImageView){
        var selected= ContextCompat.getColorStateList(requireContext(),R.color.selected_color)
        var unselected=ContextCompat.getColorStateList(requireContext(),R.color.unselected_color)
        if (it.backgroundTintList==selected){
            it.backgroundTintList= unselected
        }
        else{
            it.backgroundTintList=selected
        }
    }

    fun getList(): List<ImageSlider> {
        var list = mutableListOf<ImageSlider>()
        for (i in 1..3) {
            list.add(ImageSlider(R.drawable.img_slider))
        }
        return list
    }
}
