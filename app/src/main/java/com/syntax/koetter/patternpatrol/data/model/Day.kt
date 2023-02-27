package com.syntax.koetter.patternpatrol.data.model

data class Day(
    val thoughts: MutableList<Thought>,
    // TODO: val date: LocalDate,
    //  tmp solution
    val date: String,
    // TODO: val weekday: DayOfWeek,
    //  tmp solution
    val weekday: String
)
