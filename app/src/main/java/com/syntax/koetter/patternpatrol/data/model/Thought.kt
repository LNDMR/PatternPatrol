package com.syntax.koetter.patternpatrol.data.model


data class Thought(
    val content: String,
    val keyword: String,
    // TODO: val time: LocalTime,
    //  tmp solution
    val time: String = "10:35",
    // TODO: val date: LocalDate,
    //  tmp solution
    val date: String = "25.02.2023",
    val patterns: MutableList<Observation>? = null,
    val aiOpinion: List<Observation>? = null
)
