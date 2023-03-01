package com.syntax.koetter.patternpatrol

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syntax.koetter.patternpatrol.data.Repository
import com.syntax.koetter.patternpatrol.data.model.Day
import com.syntax.koetter.patternpatrol.data.model.Thought

// always inherits from class ViewModel
class MainViewModel: ViewModel() {

    // instance of repository
    private val repository = Repository()

    // TODO: implement API as parameter later on
    // private val repository = Repository(Api)


    // the daysList is loaded and wrapped in LiveData private & public
    private val _daysList = MutableLiveData<List<Day>>(repository.loadDays())
    val daysList: LiveData<List<Day>>
        get() = _daysList


    // TODO: double check
    // currentDay private & public
    private lateinit var _currentDay: Day
    val currentDay: Day
        get() = _currentDay


    // TODO: double check
    private val _thoughtsList = MutableLiveData<List<Thought>>(mutableListOf())
    val thoughtsList: LiveData<List<Thought>>
    get() = _thoughtsList


    // set currentDay & related thoughtList
    fun initThoughts(idx: Int){
        if(daysList != null){
            _currentDay = daysList.value!![idx]
            _thoughtsList.value = _currentDay.thoughts
        }
    }


    // TODO: chatwithme solution.

}