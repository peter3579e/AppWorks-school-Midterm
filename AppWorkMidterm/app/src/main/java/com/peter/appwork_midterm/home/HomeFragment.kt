package com.peter.appwork_midterm.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.peter.appwork_midterm.data.FireBaseDataSource
import com.peter.appwork_midterm.databinding.FragmentHomeBinding
import org.json.JSONObject

class HomeFragment:Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.viewModel=viewModel
        val adapter= HomeAdapter()
        binding.recycleView.adapter = adapter

//        FireBaseDataSource.addData()

        FireBaseDataSource.readData()

//        viewModel.item = FireBaseDataSource.list
//        viewModel.item =




        return binding.root
    }
}