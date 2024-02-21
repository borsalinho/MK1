package com.example.domain.usecase

import com.example.domain.models.SaveUserName
import com.example.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserName) : Boolean{
        val result : Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}