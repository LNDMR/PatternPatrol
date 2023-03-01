package com.syntax.koetter.patternpatrol.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.syntax.koetter.patternpatrol.MainViewModel
import com.syntax.koetter.patternpatrol.databinding.FragmentEducationalBinding
import androidx.viewpager.widget.PagerAdapter as PagerAdapter


class EducationalFragment: Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentEducationalBinding

    override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
    ): View {
       binding = FragmentEducationalBinding.inflate(inflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // val educationalTabLayout = binding.educationalTabLayout
        // val educationalPager = binding.educationalViewPager
        // Set up the ViewPager with the sections adapter
        // val adapter = PagerAdapter(supportFragmentManager)
        // educationalPager.adapter = adapter
        // Connect the TabLayout with the ViewPager
        // educationalTabLayout.setupWithViewPager(viewPager)
        // MAYBE: needs adapter & rv
        // val itemAdapter =  ItemAdapter()
        // binding.educationalItemRecycler.adapter = itemAdapter
        // MAYBE: LiveData observation
        // viewModel.XXX.observe(viewLifecycleOwner){
        //     XXX.submitList(it)
        // }
        // }
    }
}
