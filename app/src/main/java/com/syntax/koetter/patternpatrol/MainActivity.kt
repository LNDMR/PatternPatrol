package com.syntax.koetter.patternpatrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.syntax.koetter.patternpatrol.databinding.ActivityMainBinding
import com.syntax.koetter.patternpatrol.ui.EducationalFragment
import com.syntax.koetter.patternpatrol.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    // Q: do I need the data/viewBinding in the MainActivity ?
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // set default fragment
        navigateTo(HomeFragment())
        binding.bottomNav.menu.findItem(R.id.menu_home).setChecked(true)

        // LATER: menu_profile / menu_settings
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> navigateTo(HomeFragment())
                R.id.menu_educatinal -> navigateTo(EducationalFragment())
                // LATER: R.id.menu_profile -> navigateTo(Fragment())
                 else -> {
                     // Q: what comes in else ?
                 }
            }
            true
        }
    }

    // navigate between fragments via fragmentManager
    private fun navigateTo(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }

}