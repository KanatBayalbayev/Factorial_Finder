package com.qanatdev.factorialfinder.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qanatdev.factorialfinder.domain.FindFactorialUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val findFactorialUseCase: FindFactorialUseCase
) : ViewModel() {

    private val _mainViewModelState = MutableLiveData<ViewModelState>()
    val mainViewModelState: LiveData<ViewModelState> = _mainViewModelState


    fun getFactorialNumber(userNumber: String?){
        viewModelScope.launch {
            _mainViewModelState.value = ViewModelState.Loading
            if (userNumber.isNullOrBlank()){
                _mainViewModelState.value = ViewModelState.Error
            } else {
                val number = userNumber.toLong()
                val stringNumber = findFactorialUseCase.findFactorial(number).toString()
                _mainViewModelState.value = ViewModelState.FactorialNumber(stringNumber)
            }
        }
    }

}