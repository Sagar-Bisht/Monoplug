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
import com.example.monoplug.adapter.MessageAdapter
import com.example.monoplug.databinding.FragmentMessageBinding
import com.example.monoplug.model.Message


 class MessageFragment : Fragment() ,MessageAdapter.MsgClick{

    lateinit var binding: FragmentMessageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = MessageAdapter(getList(),this)
        binding.recViewMessage.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewMessage.adapter = myAdapter

    }
    fun getList() : List<Message> {
        var list = mutableListOf<Message>()
        for (i in 1..10) {
            list.add(
                Message(R.drawable.invite_img,
                    "MJ96",
                    "Hello Michel, how are you...",
                    "27/01/2022 11:00 AM")
            )
        }
        return list
    }

     override fun onClick() {
      findNavController().navigate(R.id.chatFragment)
     }
 }