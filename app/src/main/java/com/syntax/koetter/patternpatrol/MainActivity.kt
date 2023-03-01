package com.syntax.koetter.patternpatrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.syntax.koetter.patternpatrol.databinding.ActivityMainBinding
import com.syntax.koetter.patternpatrol.databinding.FragmentEducationalBinding
import com.syntax.koetter.patternpatrol.ui.EducationalFragment
import com.syntax.koetter.patternpatrol.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateTo(HomeFragment())


        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> navigateTo(HomeFragment())
                R.id.menu_educatinal -> navigateTo(EducationalFragment())
                //R.id.menu_profile -> navigateTo(Fragment())
                 else -> {
                     // TODO ?
                 }
            }
            true
        }
    }

    // this is how I found it in a tutorial online
    private fun navigateTo(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }

}