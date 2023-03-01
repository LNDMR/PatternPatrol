package com.syntax.koetter.patternpatrol.data

import com.syntax.koetter.patternpatrol.data.model.CognitiveDistortion
import com.syntax.koetter.patternpatrol.data.model.Day
import com.syntax.koetter.patternpatrol.data.model.Observation
import com.syntax.koetter.patternpatrol.data.model.Thought

class Repository {


    // TODO: prop needs modification later on
    fun loadThoughts(date: Day): MutableList<Thought>{
        // if(date.thoughts.isEmpty()){
        //     return mutableListOf<Thought>()
        // } else {
        //     return date.thoughts
        // }
        return date.thoughts
    }


    // TODO: not sure where to get the data from - maybe another API call ? Idk
    //  tmp test data
    fun loadDays(): MutableList<Day> {
        return mutableListOf(
            Day(
                toughts,
                "26",
                "Sun."
            ),
            Day(
                toughts,
                "25",
                "Sat."
            ),
            Day(
                toughts,
                "24",
                "Fri."
            ),
            Day(
                toughts,
                "23",
                "Thu."
            ),
            Day(
                toughts,
                "22",
                "Wed."
            ),
            Day(
                toughts,
                "21",
                "Tue."
            ),
            Day(
                toughts,
                "20",
                "Mon."
            )
        )
    }


    // TODO: see CognitiveDistortion file: list of cognitive distortions -> not sure where to implement etc.
    val cD1 = CognitiveDistortion(
        "ALL-OR-NOTHING THINKING",
        "You see things in black-and-white categories. If your performance falls shor" +
                " of perfect, you see yourself as a total failure.")
    val cD2 = CognitiveDistortion(
        "OVERGENERALIZATION",
        "You see a single negative event as a never-ending pattern of defeat.")
    val cD3 = CognitiveDistortion(
        "MENTAL FILTER", "You pick out a single negative detail and dwell on it" +
                " exclusively so that your vision of all reality becomes darkened, like the drop" +
                " of ink that discolors the entire beaker of water.")
    val cD4 = CognitiveDistortion(
        "DISQUALIFYING THE POSITIVE",
        "You reject positive experiences by insisting they ‘don’t count’ for some" +
                " reason or other. In this way you can maintain a negative belief that is" +
                " contradicted by your everyday experiences.")
    val cD5 = CognitiveDistortion(
        "JUMPING TO CONCLUSIONS",
        "You make a negative interpretation even though there are no definite facts" +
                " that convincingly support your conclusion.")
    val cD6 = CognitiveDistortion(
        "MIND READING",
        "You arbitrarily conclude that someone is reacting negatively to you, and you" +
                " don’t bother to check this out.")
    val cD7 = CognitiveDistortion(
        "FORTUNE TELLING",
        "You anticipate that things will turn out badly, and you feel convinced that" +
                " your prediction is an already-established fact.")
    val cD8 = CognitiveDistortion(
        "MAGNIFICATION (CATASTROPHIZING) OR MINIMIZATION",
        "You exaggerate the importance of things (such as your goof-up or someone" +
                " else’s achievement), or you inappropriately shrink things until they appear" +
                " tiny (your own desirable qualities or other fellow’s imperfections)." +
                " This is also called the ‘binocular trick.’")
    val cD9 = CognitiveDistortion(
        "EMOTIONAL REASONING",
        "You assume that your negative emotions necessarily reflect the way things" +
                " really are: ‘I feel it, therefore it must be true.’")
    val cD10 = CognitiveDistortion(
        "SHOULD STATEMENTS",
        "You try to motivate yourself with should and shouldn’t, as if you had to be" +
                " whipped and punished before you could be expected to do anything." +
                " ‘Musts’ and ‘oughts’ are also offenders. The emotional consequences are guilt." +
                " When you direct should statements toward others, you feel anger," +
                " frustration, and resentment.")
    val cD11 = CognitiveDistortion(
        "LABELING AND MISLABELING",
        "This is an extreme form of overgeneralization. Instead of describing your error," +
                " you attach a negative label to yourself. ‘I’m a loser.’ When someone else’s" +
                " behavior rubs you the wrong way, you attach a negative label to him" +
                " ‘He’s a damn louse.’ Mislabeling involves describing an event with language that" +
                " is highly colored and emotionally loaded.")
    val cD12 = CognitiveDistortion(
        "PERSONALIZATION",
        "You see yourself as the cause of some negative external event, which in fact" +
                " you were not primarily responsible for.")


    // TODO: tmp test data: list of observations
    val obs1 = Observation(cD1, "explanation of that...")
    val obs2 = Observation(cD2, "explanation of that...")
    val obs3 = Observation(cD3, "explanation of that...")
    val obs4 = Observation(cD4, "explanation of that...")
    val obs5 = Observation(cD5, "explanation of that...")


    // TODO: tmp test data: list of thoughts
    val toughts = mutableListOf<Thought>(
        Thought(
            "Today was a bad day. I forgot my keys in the appartment. I am a failure.",
            "my keys",
            "10:38",
            "25.02.2023",
            mutableListOf(obs1, obs2, obs3),
            listOf(obs4,obs5)
        ),
        Thought(
            "I finished my presentation today. It should have been done earlier. I am always late.",
            "presentation",
            "13:05",
            "25.02.2023",
            mutableListOf(obs1, obs2, obs3),
            listOf(obs4,obs5)
        ),
        Thought(
            "Peter didn't call me back. He thinks I am ugly",
            "Peter",
            "21:45",
            "25.02.2023",
            mutableListOf(obs1),
            listOf(obs4,obs5)
        )
    )
}