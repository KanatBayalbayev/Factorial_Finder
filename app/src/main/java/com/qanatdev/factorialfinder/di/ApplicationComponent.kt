package com.qanatdev.factorialfinder.di

import com.qanatdev.factorialfinder.presentation.MainActivity
import dagger.Component

@ApplicationScope
@Component(modules = [DomainModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create() : ApplicationComponent
    }
}