package com.syntax.koetter.patternpatrol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.syntax.koetter.patternpatrol.R
import com.syntax.koetter.patternpatrol.data.model.Thought
import com.syntax.koetter.patternpatrol.databinding.ThoughtItemBinding

// constructor takes parameter get the right thoughtsList from 'currentDay.thoughts'
class ThoughtAdapter(private val list: List<Thought>, val onClick: (Thought) -> Unit) : RecyclerView.Adapter<ThoughtAdapter.ThoughtViewHolder>(){

    // dataList is updated by submitList()
    // Q: first time filled ?
    private var thoughtsList: List<Thought> = list

    // view + layout that is needed to display the next item
    inner class ThoughtViewHolder(val binding: ThoughtItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindThought(thought: Thought){
            binding.thoughtKeywordText.text = thought.keyword
            binding.thoughtPreviewText.text = thought.content
            binding.thoughtTimeText.text = thought.time

            // edit already existing Thought instance in Detail Fragment
            binding.thoughtCard.setOnClickListener {
                // TODO: navigation to DetailFragment
                Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_detailFragment)
            }
        }

    }

    // is called by the RecyclerView when it needs to create a new ThoughtViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThoughtViewHolder {
        val binding = ThoughtItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ThoughtViewHolder(binding)
    }

    // called by the RV when it needs to bind a new thought item to an existing ThoughtViewHolder instance
    override fun onBindViewHolder(holder: ThoughtViewHolder, position: Int) {
        if(!thoughtsList.isEmpty()) {
            holder.bindThought(thoughtsList[position])
            holder.binding.root.setOnClickListener {
                onClick(thoughtsList[position])
            }
        } else holder.binding

    }

    // to inform the RV's LayoutManager of the total number of items that the adapter is managing
    override fun getItemCount(): Int {
        return thoughtsList.size
    }

    // TODO: needs to be observed in HF
    // Q: how ?
    fun submitList(list: List<Thought>){
        thoughtsList = list
        // notifyItemInserted()
        // notifyItemChanged()
        // notifyItemRemoved()
    }
}