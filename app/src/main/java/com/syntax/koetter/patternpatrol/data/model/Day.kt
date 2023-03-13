package com.syntax.koetter.patternpatrol.data.model

data class Day(
    val thoughts: MutableList<Thought> = mutableListOf(),
    // TODO: val date: LocalDate,
    //  tmp solution - System.currentTimeMillis() & Calendar() ??
    val date: String,
    // TODO: val weekday: DayOfWeek,
    //  tmp solution
    val weekday: String
)
