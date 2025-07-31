package com.vaskorr.testapp.domain.usecase.user

import com.vaskorr.testapp.domain.model.User
import com.vaskorr.testapp.domain.repository.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(): User? {
        return userRepository.getUser()
    }
}