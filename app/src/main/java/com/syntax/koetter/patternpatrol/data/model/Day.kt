package com.syntax.koetter.patternpatrol.data.model


import java.time.DayOfWeek
import java.time.LocalDate


data class Day(
    val thoughts: MutableList<Thought>,
    val date: LocalDate,
    val weekday: DayOfWeek
)
