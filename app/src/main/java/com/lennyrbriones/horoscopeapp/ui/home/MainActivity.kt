package com.lennyrbriones.horoscopeapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lennyrbriones.horoscopeapp.R
import com.lennyrbriones.horoscopeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Setting ViewBinding

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}