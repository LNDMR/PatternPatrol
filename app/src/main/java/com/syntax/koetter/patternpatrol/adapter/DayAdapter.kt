package com.syntax.koetter.patternpatrol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax.koetter.patternpatrol.data.model.Day
import com.syntax.koetter.patternpatrol.databinding.DayItemBinding

class DayAdapter(val onClick: (Day) -> Unit) : RecyclerView.Adapter<DayAdapter.DayViewHolder>(){

    // dataList is updated by submitList()
    // Q: first time filled ?
    private var daysList = listOf<Day>()


    // view + layout that is needed to display the next item
    inner class DayViewHolder(val binding: DayItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindDay(day: Day){
            binding.dayDayText.text = day.date
            binding.dayWeekdayText.text = day.weekday
        }
    }

    // is called by the RV when it needs to create a new ViewHolder instance to represent an item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val binding = DayItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DayViewHolder(binding)
    }

    // is called by the RV when it needs to bind a new day to an existing DayViewHolder instance
    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bindDay(daysList[position])
        holder.binding.dayCard.setOnClickListener {
            // TODO: update selected day item + bind selectedDay.thoughts to homeThoughtRV
            // Q: is this triggering a new ThoughtAdapter instance with the parameter = dayslist[position] ?
            // Q: how to update selectedDay with no access to the viewModel ?
            onClick(daysList[position])
        }
    }

    // to inform the RV's LayoutManager of the total number of items that the adapter is managing
    override fun getItemCount(): Int {
        return daysList.size
    }

    // is called in home fragment while observing VMs live data
    fun submitList(list: List<Day>) {
        daysList = list
        notifyItemInserted(list.lastIndex)
    }
}
