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
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailDateText.text = viewModel.selectedDay.value!!.date
        // Q: What about 'binding.detailKeywordEditText.text' ?
        binding.detailKeywordEditText.hint = viewModel.selectedThought.value!!.keyword.toString()


        // TODO: needs to happen in home fragment?
        // selectedThought -> RV -> bind()
        // val thoughtAdapter =  ThoughtAdapter{
        //     setSelectedThought(it)
        // }
        // binding.homeThoughtRecycler.adapter = thoughtAdapter

        // TODO: new instance ObservationAdapter + link to RV
        //  implement 'currentThought' in viewModel
        // val observationAdapter = ObservationAdapter(viewModel.currentThought.patterns)
        // binding.detailObservationRecycler.adapter = observationAdapter

        // TODO: Observer for live data patternList
        // viewModel.patternList.observe(viewLifecycleOwner){
        //     observationAdapter.submitList(it)
        // }

        // TODO: practiceButton.setOnClickListener{...} -> viewModel.currentThought.practice()
        // TODO: add new Observation => overlay list + checkboxes / radioButtons -> visibility of views in layout
    }
}