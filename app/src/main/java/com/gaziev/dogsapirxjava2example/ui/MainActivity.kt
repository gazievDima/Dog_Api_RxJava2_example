package com.gaziev.dogsapirxjava2example.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.ActivityMainBinding
import com.gaziev.dogsapirxjava2example.databinding.ToolbarBinding
import com.gaziev.dogsapirxjava2example.ui.screens.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment(), HomeFragment.TAG_SCREEN)
            .commit()

        binding.toolbar.back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }
}