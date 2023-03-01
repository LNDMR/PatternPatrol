package com.syntax.koetter.patternpatrol.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.syntax.koetter.patternpatrol.MainViewModel
import com.syntax.koetter.patternpatrol.databinding.FragmentDetailBinding

class DetailFragment: Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // dataBinding
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    // TODO: the currentThought object needs to be displayed
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //val detail
        //val itemAdapter = ItemAdapter()
        //binding.itemRecycler.adapter = itemAdapter
//
        //// livedata in viewModel is observed to give immediate update when changes occur
        //viewModel.items.observe(viewLifecycleOwner) {
        //    itemAdapter.submitList(it)
        //}
    }
}