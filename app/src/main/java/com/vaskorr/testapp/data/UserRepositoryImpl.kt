package com.vaskorr.testapp.data

import com.vaskorr.testapp.data.consts.DataConsts
import com.vaskorr.testapp.data.local.PreferencesManager
import com.vaskorr.testapp.domain.model.User
import com.vaskorr.testapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val preferencesManager: PreferencesManager
) : UserRepository {
    override fun saveUser(name: String, surname: String) {
        preferencesManager.saveString(DataConsts.USER_NAME, name)
        preferencesManager.saveString(DataConsts.USER_SURNAME, surname)
    }

    override fun getUser(): User? {
        val user = User(
            name = preferencesManager.getString(DataConsts.USER_NAME),
            surname = preferencesManager.getString(DataConsts.USER_SURNAME)
        )
        if (user.name.isEmpty() || user.surname.isEmpty()) {
            return null
        }
        return user
    }

}