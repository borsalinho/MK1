package com.example.mk1.domain.repository

import com.example.mk1.domain.models.SaveUserName
import com.example.mk1.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserName) : Boolean

    fun getName() : UserName
}