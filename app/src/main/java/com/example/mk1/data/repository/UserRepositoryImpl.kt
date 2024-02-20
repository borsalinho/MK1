package com.example.mk1.data.repository

import com.example.mk1.data.storage.models.User
import com.example.mk1.data.storage.UserStorage
import com.example.mk1.domain.models.SaveUserName
import com.example.mk1.domain.models.UserName
import com.example.mk1.domain.repository.UserRepository



class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserName) : Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        // вот сюда типа можно че нить добавить, так ж и в аргументы
        return result
    }

    override fun getName() : UserName {
        val user = userStorage.get()

        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }

    //мапперы
    private fun mapToDomain(user: User) : UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserName) : User {
        return User(firstName = saveParam.name, lastName = "")
    }

}

// может и с нетворком поработать и со сторисам поработать (с локальным хранилищем)
// будет служить как собирающий класс