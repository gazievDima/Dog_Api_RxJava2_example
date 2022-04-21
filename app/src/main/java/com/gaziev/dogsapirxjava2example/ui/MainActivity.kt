package com.gaziev.dogsapirxjava2example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.ActivityMainBinding
import com.gaziev.dogsapirxjava2example.ui.screens.home.HomeFragment


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .commit()

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }

    fun toolbarChangeTitle(title: String) {
        binding.toolbar.title = title
    }
}