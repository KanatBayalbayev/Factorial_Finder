package com.qanatdev.factorialfinder.presentation

sealed class ViewModelState{
    object Loading: ViewModelState()
    object Error: ViewModelState()
    data class FactorialNumber(val factorialNumber: String): ViewModelState()
}

