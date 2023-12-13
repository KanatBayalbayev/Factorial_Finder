package com.qanatdev.factorialfinder.data

import android.util.Log
import com.qanatdev.factorialfinder.domain.FactorialFinder
import java.math.BigInteger
import javax.inject.Inject

class FactorialFinderImpl @Inject constructor() : FactorialFinder {

    override suspend fun findFactorial(number: Long): BigInteger {
        var result = BigInteger.ONE

        for (i in 1..number){
            result = result.multiply(BigInteger.valueOf(i))

        }


        return result

    }
}