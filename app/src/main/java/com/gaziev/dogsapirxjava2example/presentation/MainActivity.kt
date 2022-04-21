package com.gaziev.dogsapirxjava2example.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val controller: NavController by lazy { (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        if(!controller.popBackStack()) finish()
    }

    fun toolbarChangeTitle(title: String) {
        binding.toolbar.title = title
    }
}