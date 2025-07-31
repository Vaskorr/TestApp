package com.vaskorr.testapp.presentation.screen.main

import com.vaskorr.testapp.domain.usecase.user.GetUserUseCase
import com.vaskorr.testapp.presentation.util.MviViewModel

class MainViewModel(
    getUserUseCase: GetUserUseCase
) : MviViewModel<MainScreenState, MainAction, MainEffect>(
    MainScreenState()
) {
    override fun onAction(action: MainAction) {}

    init {
        changeState {
            it.copy(
                user = getUserUseCase.invoke()
            )
        }
    }
}