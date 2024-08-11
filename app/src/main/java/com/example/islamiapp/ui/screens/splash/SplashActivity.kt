package com.example.islamiapp.ui.screens.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islamiapp.databinding.SplashActivityBinding
import com.example.islamiapp.ui.screens.home.FirstActivity

class SplashActivity : AppCompatActivity() {
   private lateinit var binding : SplashActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({        startActivity(intent)
        },2000)
        val intent = Intent(this,FirstActivity::class.java)
        startActivity(intent)
    }
}