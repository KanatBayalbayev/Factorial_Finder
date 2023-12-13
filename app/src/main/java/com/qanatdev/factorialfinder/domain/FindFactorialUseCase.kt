package com.qanatdev.factorialfinder.domain

import java.math.BigInteger
import javax.inject.Inject

class FindFactorialUseCase @Inject constructor(private val factorialFinder: FactorialFinder) {

    suspend operator fun invoke(number: Long) : BigInteger{
       return factorialFinder.findFactorial(number)
    }
}