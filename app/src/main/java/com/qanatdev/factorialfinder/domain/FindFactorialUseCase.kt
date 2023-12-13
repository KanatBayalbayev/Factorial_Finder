package com.qanatdev.factorialfinder.domain

import javax.inject.Inject

class FindFactorialUseCase @Inject constructor(private val factorialFinder: FactorialFinder) {

    suspend fun findFactorial(number: Long) {
        factorialFinder.findFactorial(number)
    }
}