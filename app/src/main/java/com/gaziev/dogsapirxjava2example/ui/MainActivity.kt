package com.gaziev.dogsapirxjava2example.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.ActivityMainBinding
import com.gaziev.dogsapirxjava2example.ui.screens.home.HomeFragment
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
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