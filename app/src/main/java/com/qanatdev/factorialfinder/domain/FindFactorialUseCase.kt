package com.qanatdev.factorialfinder.domain

import java.math.BigInteger
import javax.inject.Inject

class FindFactorialUseCase @Inject constructor(private val factorialFinder: FactorialFinder) {

    suspend fun findFactorial(number: Long) : BigInteger{
       return factorialFinder.findFactorial(number)
    }
}