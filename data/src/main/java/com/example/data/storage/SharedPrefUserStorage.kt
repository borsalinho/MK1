package com.example.data.storage.implementations

import android.content.Context
import com.example.data.storage.UserStorage
import com.example.data.storage.implementations.DEFAULT_FIRST_NAME
import com.example.data.storage.implementations.DEFAULT_LAST_NAME
import com.example.data.storage.implementations.KEY_FIRST_NAME
import com.example.data.storage.implementations.KEY_LAST_NAME
import com.example.data.storage.implementations.SHARED_PREFS_NAME
import com.example.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_LAST_NAME = "Default last name"
private const val DEFAULT_FIRST_NAME = "Default first name"


class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE
    )

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(
            KEY_FIRST_NAME,
            DEFAULT_FIRST_NAME
        ) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(
            KEY_LAST_NAME,
            DEFAULT_LAST_NAME
        ) ?: DEFAULT_LAST_NAME

        return User(firstName = firstName, lastName = lastName)
    }

} // класс ТОЛЬКО ДЛЯ СОХРАНЕНИЯ ДАННЫХ