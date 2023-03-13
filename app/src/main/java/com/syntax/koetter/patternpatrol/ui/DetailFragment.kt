package com.syntax.koetter.patternpatrol.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.syntax.koetter.patternpatrol.MainViewModel
import com.syntax.koetter.patternpatrol.adapter.DistortionAdapter
import com.syntax.koetter.patternpatrol.adapter.ObservationAdapter
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

        if (viewModel.selectedThought.value!!.content.isEmpty()){
            binding.detailDateText.text = viewModel.selectedDay.value!!.date
            binding.detailKeywordEditText.hint = "keyword"
            binding.detailContentEditMultiText.hint = "..."
        } else {
            binding.detailDateText.text = viewModel.selectedDay.value!!.date
            binding.detailKeywordEditText.text.insert(0,viewModel.selectedThought.value!!.keyword)
            binding.detailContentEditMultiText.text.insert(0,viewModel.selectedThought.value!!.content)
            if (viewModel.selectedThought.value!!.patterns!!.isEmpty()){
                // TODO: do not show observation RV
            } else{
                // TODO: show observation RV & observationAdapter
            }
            if (viewModel.selectedThought.value!!.aiOpinion!!.isEmpty()){
                // TODO: do not show observationAI RV
            } else{
                // TODO: show observationAI RV & observationAIAdapter
            }
        }

        // TODO: practiceButton.setOnClickListener{...}
        binding.detailPracticeButton.setOnClickListener {
            // TODO: show CDs & CDAdapter, button invisible
        }

        val distortionAdapter = DistortionAdapter(viewModel.distortionsList.value!!)
        binding.detailDistortionRecycler.adapter = distortionAdapter

        // observer for live data distortionsList
        viewModel.distortionsList.observe(viewLifecycleOwner) {
            distortionAdapter.submitList(it)
        }

        // 6. show RV
        //         7. RV: observation_item + setOnClickListener{..}
        // → edit mode
        // else
        // 8. don’t show RV
        // if selectedThought.aiOpinion.isNotEmpty() =
        //     9. new Observation Adapter (selectedThought.aiOpinion)
        // 10. show RV
        //         11. RV: observation_item
        // else
        // 12. don’t show RV
        // 13. SaveButton +  setOnClickListener{..}
        // → save input in Thought instance
        // → show PracticeButton
        //         14. PracticeButton +  setOnClickListener{..} (→ done in viewModel or here?)
        // → show SaveButton
        // → show List of Distortions ⇒ options
        // 15. RV?: distortion_item + setOnClickListener{..}
        // → show description
        // → RadioButton? & show RV: new Instance of Observation: edit mode
        // 16. BackArrowButton +  setOnClickListener{..}
        // → nav to HomeFragment & selectedDay stays the same
        // 17. HelpButton +  setOnClickListener{..}
        // → viewModel.askAiForHelp(selectedThought.content)
        // → show RV: selectedThought.aiOpinion

        // TODO: Observer for live data patternList
        // viewModel.patternList.observe(viewLifecycleOwner){
        //     observationAdapter.submitList(it)
        // }


    }
}