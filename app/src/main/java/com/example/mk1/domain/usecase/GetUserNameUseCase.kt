package com.example.mk1.domain.usecase

import com.example.mk1.domain.models.UserName
import com.example.mk1.domain.repository.UserRepository

class GetUserNameUseCase(private  val userRepository: UserRepository) {

    fun execute() : UserName{
        return userRepository.getName()
    }

}