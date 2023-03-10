package com.syntax.koetter.patternpatrol.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.syntax.koetter.patternpatrol.MainViewModel
import com.syntax.koetter.patternpatrol.R
import com.syntax.koetter.patternpatrol.adapter.DayAdapter
import com.syntax.koetter.patternpatrol.adapter.ThoughtAdapter
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

        // new instance DayAdapter + sets selectedDay in viewModel + link to RV
        // PROBLEM: selectedDay is not set on anything in the beginning = null -> that does not work
        val dayAdapter = DayAdapter {
            viewModel.setSelectedDay(it)
        }
        // PROBLEM: println("TAG:" + viewModel.selectedDay.value.toString())
        binding.homeDayRecycler.adapter = dayAdapter

        // PROBLEM: ongoing - thoughtsList is empty in beginning
        // gets attribute thoughts via current selectedDay
        // new instance ThoughtAdapter + link to RV
        val thoughtAdapter = ThoughtAdapter(viewModel.selectedDay.value!!.thoughts) {
            viewModel.setSelectedThought(it)
        }
        binding.homeThoughtRecycler.adapter = thoughtAdapter

        // LATER: Thought RV should be invisible if thoughtsList is empty
        //  if (viewModel.selectedDay.value!!.thoughts.isEmpty())
        //     binding.homeThoughtRecycler.setVisibility(View.INVISIBLE)

        // observer for live data selectedDay
        // Q: is necessary ?
        viewModel.selectedDay.observe(viewLifecycleOwner) {
            // TODO: selectedDay needs to be updated
            }

        binding.homeThoughtRecycler.adapter = thoughtAdapter

            // if (viewModel.selectedDay.value!!.thoughts.isEmpty()) {
            //     binding.homeThoughtRecycler.setVisibility(View.INVISIBLE)
            // }

        // observer for live data daysList
        viewModel.daysList.observe(viewLifecycleOwner) {
            dayAdapter.submitList(it)
        }

        // observer for live data thoughtsList
        // TODO: is triggered when selectedDay is updated
        viewModel.thoughtsList.observe(viewLifecycleOwner) {
            thoughtAdapter.submitList(it)
        }


        // TODO: add new Thought
        binding.homeAddButton.setOnClickListener {
            // TODO: navigation to DetailFragment + create new Thought instance
            // Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_detailFragment)
            Navigation.findNavController(binding.root).navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment())
        }
    }
}