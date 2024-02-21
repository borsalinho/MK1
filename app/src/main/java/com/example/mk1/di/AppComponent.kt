package com.example.mk1.di

import com.example.mk1.presentation.activities.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}