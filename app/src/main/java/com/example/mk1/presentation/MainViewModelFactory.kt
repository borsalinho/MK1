package com.example.mk1.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
//import com.example.data.storage.SharedPrefUserStorage
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import com.example.mk1.presentation.viewmodel.MainViewModel

class MainViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
)  : ViewModelProvider.Factory {

//    тут идет иницилизация обьектов, но все это делается в di
//    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
//        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
//    }
//    private val getUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE) {
//        GetUserNameUseCase(userRepository = userRepository)
//    }
//    private val saveUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE) {
//        SaveUserNameUseCase(userRepository = userRepository)
//    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }

}