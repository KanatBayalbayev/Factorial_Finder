package com.qanatdev.factorialfinder.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.qanatdev.factorialfinder.MainApp
import com.qanatdev.factorialfinder.R
import com.qanatdev.factorialfinder.databinding.ActivityMainBinding
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

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        findFactorial()
        observeMainViewModel()


    }
    private fun findFactorial(){
        with(binding){
            buttonToFindFactorial.setOnClickListener {
                val userInput = userInput.text.toString().trim()
                mainViewModel.getFactorialNumber(userInput)
            }
        }
    }
    private fun observeMainViewModel(){
        mainViewModel.mainViewModelState.observe(this){
            with(binding){
                when(it){
                    is ViewModelState.Loading -> {
                        Log.d("TestFor", "Loading...")
                    }
                    is ViewModelState.Error -> {
                        Log.d("TestFor", "Error...")
                    }
                    is ViewModelState.FactorialNumber -> {
                        Log.d("TestFor", "The result is ${it.factorialNumber}")
                        result.text = it.factorialNumber
                    }
                }
            }

        }
    }




}