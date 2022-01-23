package com.example.cucumberandroid

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cucumberandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counter.text = count.toString()
        binding.incrementer.setOnClickListener(this::increment)
        binding.decrementer.setOnClickListener(this::decrement)
    }

    private fun increment(v: View) {
        count++

        binding.counter.text = count.toString()
    }

    private fun decrement(v: View) {
        if (count > 0) {
            count--
        }

        binding.counter.text = count.toString()
    }
}