package com.qanatdev.factorialfinder.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qanatdev.factorialfinder.domain.FindFactorialUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val findFactorialUseCase: FindFactorialUseCase
) : ViewModel() {

    private val _mainViewModelState = MutableLiveData<ViewModelState>()
    val mainViewModelState: LiveData<ViewModelState> = _mainViewModelState


    fun getFactorialNumber(userNumber: String?) {
        viewModelScope.launch {
            _mainViewModelState.value = ViewModelState.Loading
            if (userNumber.isNullOrBlank()) {
                _mainViewModelState.value = ViewModelState.Error
                return@launch
            }
            val number = userNumber.toLong()
            val stringNumber = factorialNumber(number).toString()
            _mainViewModelState.value = ViewModelState.FactorialNumber(stringNumber)
        }
    }

    private suspend fun factorialNumber(number: Long): BigInteger {
        return withContext(Dispatchers.Default) {
            findFactorialUseCase.findFactorial(number)
        }
    }

}