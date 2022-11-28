package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.InviteFeatureAdapter
import com.example.monoplug.databinding.FragmentInviteFeatureBinding
import com.example.monoplug.model.InviteFeature


class InviteFeatureFragment : Fragment() {

    lateinit var binding : FragmentInviteFeatureBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_invite_feature, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = InviteFeatureAdapter(getList())
        binding.recViewInviteFeature.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewInviteFeature.adapter = myAdapter
    }

    fun getList() : List<InviteFeature> {
        var list = mutableListOf<InviteFeature>()
        for (i in 1..10) {
            list.add(
                InviteFeature(R.drawable.blogs_img,
                    "John Doe",
                    "Drummer",
                    "\$250")
            )
        }
        return list
    }

}