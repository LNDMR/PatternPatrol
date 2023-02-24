package com.syntax.koetter.patternpatrol.data.model

import java.time.LocalTime

data class Thought(
    val content: String,
    val keyword: String,
    val time: LocalTime,
    val patterns: MutableList<Observation>,
    val aiOpinion: List<Observation>
)
