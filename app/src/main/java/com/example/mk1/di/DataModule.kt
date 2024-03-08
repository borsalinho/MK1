package com.example.mk1.di

import android.content.Context
import com.example.data.network.ProductsDtoApi
import com.example.data.repositoryimpl.ProductsRepositoryImpl
import com.example.data.repositoryimpl.UserRepositoryImpl
import com.example.data.storage.UserStorage
import com.example.data.storage.database.ProductsDB
import com.example.data.storage.implementations.SharedPrefUserStorage
import com.example.domain.repository.ProductsRepository
import com.example.domain.repository.UserRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL =
    "https://dummyjson.com"

@Module
class DataModule {

    // -------------------network-------------------
    @Provides
    @Singleton
    fun provideGson() : Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideClient(interceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    }

    // создание экземпляра, который реализует интерфейс DTO
    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit) : ProductsDtoApi{
        return retrofit.create(ProductsDtoApi::class.java)
    }

    // -------------------storage-------------------
    @Provides
    @Singleton
    fun provideProductDB(context: Context) : ProductsDB {
        return ProductsDB.getDataBase(context)
    }


    // ------------------repositoryimpl-------------------

    @Provides
    fun provideProductsRepositoryImpl(): ProductsRepository {
        return ProductsRepositoryImpl()
    }


    // -------------------test-------------------
    @Provides
    fun provideUserStorage(context: Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepositoryImpl(userStorage: UserStorage) : UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }

}