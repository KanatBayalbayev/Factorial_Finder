package com.qanatdev.factorialfinder.di

import com.qanatdev.factorialfinder.data.FactorialFinderImpl
import com.qanatdev.factorialfinder.domain.FactorialFinder
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {


    @Binds
    fun bindFactorialFinderImpl(factorialFinderImpl: FactorialFinderImpl): FactorialFinder
}