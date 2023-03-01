package com.syntax.koetter.patternpatrol.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syntax.koetter.patternpatrol.R
import com.syntax.koetter.patternpatrol.data.model.Day
import com.syntax.koetter.patternpatrol.data.model.Thought

// TODO: maybe constructor needs a parameter (val date: Day) to fill thoughtList -> date.thoughts
class ThoughtAdapter() : RecyclerView.Adapter<ThoughtAdapter.ThoughtViewHolder>(){

    // TODO: understand where & how it ll be filled
    private var thoughtsList = listOf<Thought>()


    // is aware of the specific parts of the layout that need to be updated when the view is recycled
    inner class ThoughtViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val thoughtKeyword: TextView = view.findViewById(R.id.thought_keyword_text)
        val thoughtDate: TextView = view.findViewById(R.id.thought_date_text)
        val thoughtTime: TextView = view.findViewById(R.id.thought_time_text)
        val thoughtPreview: TextView = view.findViewById(R.id.thought_preview_text)
    }


    // is called by the RecyclerView when it needs to create a new ThoughtViewHolder
    // TODO: proper understanding
    //  parameters: ViewGroup ? & why is viewType = Int ?
    //  return: LayoutInflater returns instance of View ?
    //  .form(context) ?
    //  .inflate(layout-resource-id, root, isAttachedToRoot) ?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThoughtViewHolder {
        val thoughtLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.thought_item, parent, false)
        return ThoughtViewHolder(thoughtLayout)
    }


    // TODO: submitList(list)
    fun submitList(list: List<Thought>){
        thoughtsList = list
        notifyItemInserted(list.lastIndex)
    }


    // to inform the RecyclerView's LayoutManager of the total number of items in the dataset that the adapter is managing
    override fun getItemCount(): Int {
        return thoughtsList.size
    }


    // is called by the RecyclerView when it needs to bind a new thought to an existing ThoughtViewHolder instance
    override fun onBindViewHolder(holder: ThoughtViewHolder, position: Int) {
        val thought = thoughtsList[position]

        // UI elements get to display new content
        holder.thoughtKeyword.text = thought.keyword
        holder.thoughtPreview.text = thought.content
        // TODO: Time and Date objects need to be converted to String later on
        //  for now they are implemented as Strings anyway
        holder.thoughtDate.text = thought.date
        holder.thoughtTime.text = thought.time
    }
}