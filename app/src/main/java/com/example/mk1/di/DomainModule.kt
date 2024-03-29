package com.example.mk1.di

import com.example.domain.repository.ProductsRepository
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.LoadProductsFromApiUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideLoadProductsFromApiUseCase(productsRepository: ProductsRepository) : LoadProductsFromApiUseCase {
        return LoadProductsFromApiUseCase(productsRepository = productsRepository)
    }

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository) : GetUserNameUseCase{
        return  GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository = userRepository)
    }

}