package com.syntax.koetter.patternpatrol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax.koetter.patternpatrol.data.model.CognitiveDistortion
import com.syntax.koetter.patternpatrol.databinding.DistortionItemBinding

class DistortionAdapter(private val list: List<CognitiveDistortion>) : RecyclerView.Adapter<DistortionAdapter.DistortionViewHolder>() {

    private var distortionsList: List<CognitiveDistortion> = list

    // view + layout that is needed to display the next item
    inner class DistortionViewHolder(val binding: DistortionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindDistortion(cd: CognitiveDistortion) {
            binding.distortionNameText.text = cd.name
            binding.distortionDescriptionText.text = cd.description
        }
    }

    // is called by the RecyclerView when it needs to create a new DistortionViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistortionViewHolder {
        val binding =
            DistortionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DistortionViewHolder(binding)
    }

    // called by the RV when it needs to bind a new thought item to an existing DistortionViewHolder instance
    override fun onBindViewHolder(holder: DistortionViewHolder, position: Int) {
        holder.bindDistortion(distortionsList[position])
        holder.binding.distortionNameText.setOnClickListener {
            // TODO: set distortionDescriptionText visible
            // holder.binding.distortionDescriptionText
        }
    }

    // to inform the RV's LayoutManager of the total number of items that the adapter is managing
    override fun getItemCount(): Int {
        return distortionsList.size
    }

    // TODO: needs to be observed in DF
    // Q: does it really ?
    fun submitList(list: List<CognitiveDistortion>) {
        distortionsList = list
        // notifyItemInserted()
        // notifyItemChanged()
        // notifyItemRemoved()
    }
}