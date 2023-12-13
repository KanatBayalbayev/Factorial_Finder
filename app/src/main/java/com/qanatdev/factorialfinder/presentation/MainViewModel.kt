package com.qanatdev.factorialfinder.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.qanatdev.factorialfinder.domain.FindFactorialUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val findFactorialUseCase: FindFactorialUseCase
) : ViewModel() {



    suspend fun getFactorialNumber(userNumber: Long){
        findFactorialUseCase.findFactorial(userNumber)
    }

}