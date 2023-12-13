package com.qanatdev.factorialfinder.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.qanatdev.factorialfinder.MainApp
import com.qanatdev.factorialfinder.R
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val mainViewModel by lazy {
        ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (application as MainApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.mainViewModelState.observe(this){
            when(it){
                is ViewModelState.Loading -> {
                    Log.d("MainActivity", "Loading...")
                }
                is ViewModelState.Error -> {
                    Log.d("MainActivity", "Error...")
                }
                is ViewModelState.FactorialNumber -> {
                    Log.d("MainActivity", "The result is ${it.factorialNumber}")
                }
            }
        }
        mainViewModel.getFactorialNumber("4")
    }
}