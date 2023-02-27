package com.syntax.koetter.patternpatrol

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syntax.koetter.patternpatrol.data.Repository
import com.syntax.koetter.patternpatrol.data.model.Day

// always inherits from class ViewModel
class MainViewModel: ViewModel() {

    // instance of repository
    private val repository = Repository()


    // TODO: LiveData stuff - double check & possible adjustments
    private val _daysList = MutableLiveData<List<Day>>(repository.loadDays())
    val daysList: LiveData<List<Day>>
        get() = _daysList


    // TODO: LiveData stuff - adjustments regarding parameter (day = XXX) - when & how
    // private val _thoughtsList = MutableLiveData<List<Thought>>(repository.loadThoughts(XXX))
    // val thoughtsList: LiveData<List<Thought>>
    //     get() = _thoughtsList


    // TODO: more LiveData ? (thought.patterns / thought.aiOpinion = observationList)

    // TODO: everything else
}