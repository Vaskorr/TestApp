package com.vaskorr.testapp.presentation.screen.register

import androidx.lifecycle.viewModelScope
import com.vaskorr.testapp.domain.usecase.user.SaveUserUseCase
import com.vaskorr.testapp.presentation.util.MviViewModel
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val saveUserUseCase: SaveUserUseCase
) : MviViewModel<RegisterScreenState, RegisterAction, RegisterEffect>(
    RegisterScreenState()
) {
    override fun onAction(action: RegisterAction) {
        when (action) {
            RegisterAction.GoFurther -> onGoFurther()
            is RegisterAction.OnBankCodeChange -> updateBankCode(action.code)
            is RegisterAction.OnBankNumberChange -> updateBankNumber(action.number)
            is RegisterAction.OnNameChange -> updateName(action.name)
            is RegisterAction.OnSurnameChange -> updateSurname(action.surname)
        }
    }

    private fun onGoFurther() {
        viewModelScope.launch {
            saveUserUseCase.invoke(
                name = uiState.value.name ?: "",
                surname = uiState.value.surname ?: ""
            )
            sendEffect(RegisterEffect.GoFurther)
        }
    }

    private fun updateBankNumber(number: String) {
        changeState {
            it.copy(
                bankNumber = number
            )
        }
    }

    private fun updateBankCode(code: String) {
        changeState {
            it.copy(
                bankCode = code
            )
        }
    }

    private fun updateName(name: String) {
        changeState {
            it.copy(
                name = name
            )
        }
    }

    private fun updateSurname(surname: String) {
        changeState {
            it.copy(
                surname = surname
            )
        }
    }

}