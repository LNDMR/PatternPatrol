package com.syntax.koetter.patternpatrol.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.syntax.koetter.patternpatrol.MainViewModel
import com.syntax.koetter.patternpatrol.adapter.DayAdapter
import com.syntax.koetter.patternpatrol.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dayAdapter =  DayAdapter()
        binding.homeDayRecycler.adapter = dayAdapter

        viewModel.daysList.observe(viewLifecycleOwner){
            dayAdapter.submitList(it)
        }

        // if there s a change in the list observed then call submitList() on the adapter for updating the list
        viewModel.thoughtsList.observe(viewLifecycleOwner){
            // TODO: access thoughtAdapter.submitList(it) - how ?
        }
    }
}