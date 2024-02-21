package com.example.mk1.app

import android.app.Application
import com.example.mk1.di.AppComponent
import com.example.mk1.di.AppModule
import com.example.mk1.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }
}