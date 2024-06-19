package com.S21.mk1.di

import com.S21.mk1.presentation.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    DomainModule::class
])
interface AppComponent {
    fun inject(activity: MainActivity)
}