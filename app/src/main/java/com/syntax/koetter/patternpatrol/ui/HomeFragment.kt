package com.syntax.koetter.patternpatrol.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.syntax.koetter.patternpatrol.MainViewModel
import com.syntax.koetter.patternpatrol.R
import com.syntax.koetter.patternpatrol.adapter.DayAdapter
import com.syntax.koetter.patternpatrol.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // TODO: understand when to use only one viewModel or several in project
    private val viewModel: MainViewModel by viewModels()

    // TODO: understand properly - (viewBindung vs. dataBinding ?)
    // TODO: ERROR
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dayAdapter =  DayAdapter()
        // TODO: ERROR
        binding.homeDayRecycler.adapter = dayAdapter
    }
}