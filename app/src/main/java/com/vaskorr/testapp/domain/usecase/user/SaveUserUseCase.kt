package com.vaskorr.testapp.domain.usecase.user

import com.vaskorr.testapp.domain.repository.UserRepository

class SaveUserUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(name: String, surname: String) {
        return userRepository.saveUser(name, surname)
    }
}