package com.S21.mk1.myapp

import android.app.Application
import com.S21.mk1.di.AppComponent
import com.S21.mk1.di.AppModule
import com.S21.mk1.di.DaggerAppComponent


class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}