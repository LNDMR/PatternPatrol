package com.syntax.koetter.patternpatrol.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.syntax.koetter.patternpatrol.MainViewModel
import com.syntax.koetter.patternpatrol.R
import com.syntax.koetter.patternpatrol.data.model.Day

// TODO: MAYBE: constructor parameter 'viewModel: MainViewModel' ?
class DayAdapter() : RecyclerView.Adapter<DayAdapter.DayViewHolder>(){

    // TODO: forgot where dataList is filled
    private var daysList = listOf<Day>()

    // TODO: MAYBE: doesn't work
    // val viewModel: MainViewModel = viewModel

    // is aware of the specific parts of the layout that need to be updated when the view is recycled
    inner class DayViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val dayWeekday: TextView = view.findViewById(R.id.day_weekday_text)
        val dayDay: TextView = view.findViewById(R.id.day_day_text)
        val dayCard: CardView = view.findViewById(R.id.day_card)
        // val thoughtRecycler: RecyclerView = view.findViewById(R.id.home_thought_recycler)
    }


    // is called by the RecyclerView when it needs to create a new ViewHolder to represent an item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val dayLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.day_item, parent, false)
        return DayViewHolder(dayLayout)
    }


    // to inform the RecyclerView's LayoutManager of the total number of items in the dataset that the adapter is managing
    override fun getItemCount(): Int {
        return daysList.size
    }


    // TODO: understand submitList(list)
    fun submitList(list: List<Day>) {
        daysList = list
        notifyItemInserted(list.lastIndex)
    }

    // is called by the RecyclerView when it needs to bind a new day to an existing DayViewHolder instance
    // TODO: continue to build
    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day = daysList[position]

        // UI elements get to display new content
        holder.dayWeekday.text = day.weekday
        holder.dayDay.text = day.date

        holder.dayCard.setOnClickListener {
            // TODO: new ThoughtAdapter, maybe needs parameter (day)
            // val thoughtAdapter = ThoughtAdapter()
            //holder.thoughtRecycler.adapter = thoughtAdapter
            // TODO: MAYBE: doesn't work
            // viewModel.currentDay(day)
            // thoughtAdapter.submitList(day.thoughts)
            // TODO: thoughtList & submit()
        }
    }
}
