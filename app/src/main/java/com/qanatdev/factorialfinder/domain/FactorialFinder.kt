package com.qanatdev.factorialfinder.domain

import java.math.BigInteger

interface FactorialFinder {

  suspend  fun findFactorial(number: Long): BigInteger
}