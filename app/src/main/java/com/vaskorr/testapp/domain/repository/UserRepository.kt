package com.vaskorr.testapp.domain.repository

import com.vaskorr.testapp.domain.model.User

interface UserRepository {
    fun saveUser(name: String, surname: String)
    fun getUser(): User
}