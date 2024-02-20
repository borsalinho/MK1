package com.example.mk1.domain.usecase

import com.example.mk1.domain.models.SaveUserName
import com.example.mk1.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserName) : Boolean{
        val result : Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}