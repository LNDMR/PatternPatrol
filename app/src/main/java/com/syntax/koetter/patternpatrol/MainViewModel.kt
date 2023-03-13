package com.syntax.koetter.patternpatrol

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syntax.koetter.patternpatrol.data.Repository
import com.syntax.koetter.patternpatrol.data.model.CognitiveDistortion
import com.syntax.koetter.patternpatrol.data.model.Day
import com.syntax.koetter.patternpatrol.data.model.Thought

// always inherits from class ViewModel
class MainViewModel: ViewModel() {

    // LATER: implement API parameter: private val repository = Repository(Api)
    private val repository = Repository()

    // the daysList is loaded and wrapped in LiveData private(mutable) & public(static)
    private val _daysList = MutableLiveData<List<Day>>(repository.loadDays())
    val daysList: LiveData<List<Day>>
        get() = _daysList

    // PROBLEM: default for selectedDay = current day
    private var _selectedDay = MutableLiveData<Day>()
    val selectedDay: LiveData<Day>
        get() = _selectedDay

    // PROBLEM: is called at instantiation of DayAdapter but does not have any starting item -> does not work
    fun setSelectedDay(day: Day){
        _selectedDay.value = day
    }

    // PROBLEM: ongoing
    // selectedDay.thoughts wrapped in LiveData private(mutable) & public(static)
    private val _thoughtsList = MutableLiveData<List<Thought>>(selectedDay.value?.thoughts)
    val thoughtsList: LiveData<List<Thought>>
        get() = _thoughtsList

    // PROBLEM: ongoing
    // selectedThought is determined when thought_item is clicked -> is wrapped in LiveData private(mutable) & public(static)
    private var _selectedThought = MutableLiveData<Thought>()
    val selectedThought: LiveData<Thought>
        get() = _selectedThought

    // Q: is necessary? is fix ..
    // distortionsList wrapped in LiveData private(mutable) & public(static)
    private val _distortionsList = MutableLiveData<List<CognitiveDistortion>>(repository.loadDistortions())
    val distortionsList: LiveData<List<CognitiveDistortion>>
        get() = _distortionsList


    init {
        _selectedDay.value = daysList.value?.last()
        _daysList.value = daysList.value
        _thoughtsList.value = selectedDay.value?.thoughts
        _distortionsList.value = distortionsList.value
    }

    // is called at instantiation of ThoughtAdapter
    fun setSelectedThought(thought: Thought){
        _selectedThought.value = thought
    }

    // TODO:
    fun newThought(content: String) {
        // val newThought = Thought(content, "TODAY", "12:12", "02.02.2023", mutableListOf(), mutableListOf())
        // _thoughtsList.value?.toMutableList()?.add(0, newThought)
        // _thoughtsList.value = thoughtsList.value
    }

    // LATER: AI Api call
    fun askAiForHelp(userInput: String) {
        // Stuff to hand over to AI Api call:
        // val context: String
        // val userInput: String
        // val instruction: String
        // returns or adds MutableListOf<Observations> to current Thought
    }

    // TODO:
    fun practice(){
        // show List of CD
        // radiobutton.setOnClickListener{...} -> new Instance of Observation()
        // observation.name is a constant, observation.explanation is empthy by default
        // if observation is not empty -> observation.isDone == true -> checkImage
    }

    // TODO:
    fun addThought(newThought: Thought){
        // selectedDay.thoughts.add(newThought)
        // notifyItemInserted(thoughts.lastIndex)
    }

    // TODO:
    fun deleteThought(thought: Thought){
        // selectedDay = Day()
        // val tmp = selectedDay.thoughts.indexOf(thought)
        // selectedDay.thoughts.remove(thought)
        // notifyItemRemoved(tmp)
    }
}