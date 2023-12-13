package com.qanatdev.factorialfinder

import android.app.Application
import com.qanatdev.factorialfinder.di.DaggerApplicationComponent

class MainApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create()
    }

}