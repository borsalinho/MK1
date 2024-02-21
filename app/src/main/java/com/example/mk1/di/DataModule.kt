package com.example.mk1.di

import android.content.Context
import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.SharedPrefUserStorage
import com.example.data.storage.UserStorage
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepositoryImpl(userStorage: UserStorage) : UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }

}