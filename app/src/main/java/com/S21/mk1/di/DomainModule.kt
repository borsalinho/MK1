package com.S21.mk1.di

import android.content.Context
import com.s21.data.implementations.DataRepositoryImpl
import com.s21.data.implementations.NetworkRepositoryImpl
import com.s21.domain.repository.DataRepository
import com.s21.domain.repository.NetworkRepository
import com.s21.domain.repository.Repository
import com.s21.domain.usecases.GetDataUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetDataUseCase(repository: Repository) : GetDataUseCase {
        return GetDataUseCase(repository = repository)
    }

    @Provides
    fun provideDataRepositoryImpl(context : Context) : DataRepository {
        return DataRepositoryImpl(context = context)
    }

    @Provides
    fun provideNetworkRepositoryImpl() : NetworkRepository {
        return NetworkRepositoryImpl()
    }


    @Provides
    fun provideRepository(
        dataRepository: DataRepository,
        networkRepository: NetworkRepository
    ) : Repository {
        return Repository(
            dataRepository = dataRepository,
            networkRepository = networkRepository
        )
    }
}