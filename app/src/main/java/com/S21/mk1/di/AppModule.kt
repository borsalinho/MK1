package com.S21.mk1.di

import android.content.Context
import com.S21.mk1.presentation.viewmodels.MainViewModel
import com.s21.domain.usecases.GetDataUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() : Context {
        return context
    }

    @Provides
    @Singleton
    fun provideMainViewModel(getDataUseCase : GetDataUseCase) : MainViewModel{
        return MainViewModel(getDataUseCase = getDataUseCase)
    }

}