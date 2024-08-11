package com.example.islamiapp.ui.screens.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityFirstBinding
import com.example.islamiapp.ui.screens.home.ahadeth.AhadethFragment
import com.example.islamiapp.ui.screens.home.quran.QuraanFragment
import com.example.islamiapp.ui.screens.home.radio.radioFragment
import com.example.islamiapp.ui.screens.home.sebha.SebhaFragment

class FirstActivity : AppCompatActivity() {
   private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initListeners()
    }

    private fun initListeners() {
       binding!!.buttonNavView.setOnItemSelectedListener {menuitem ->
               when(menuitem.itemId){
                   R.id.Quran ->{
                                showFragment(QuraanFragment())
                   }
                   R.id.sebha ->{
                       showFragment(SebhaFragment())

                   }
                   R.id.ahdeth ->{
                       showFragment(AhadethFragment())

                   }
                   R.id.radio ->{
                       showFragment(radioFragment())

                   }
               }

           return@setOnItemSelectedListener true

       }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_tag,fragment)
            .commit()
    }
}