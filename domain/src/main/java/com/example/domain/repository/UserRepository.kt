package com.example.domain.repository

import com.example.domain.models.SaveUserName
import com.example.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserName) : Boolean

    fun getName() : UserName
}