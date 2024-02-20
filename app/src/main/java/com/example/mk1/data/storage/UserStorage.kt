package com.example.mk1.data.storage

import com.example.mk1.data.storage.models.User


interface UserStorage {

    fun save(user: User): Boolean

    fun get() : User
}