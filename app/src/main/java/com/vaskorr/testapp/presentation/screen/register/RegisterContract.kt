package com.vaskorr.testapp.presentation.screen.register

import androidx.core.text.isDigitsOnly
import com.vaskorr.testapp.presentation.util.MviAction
import com.vaskorr.testapp.presentation.util.MviEffect
import com.vaskorr.testapp.presentation.util.MviState

data class RegisterScreenState(
    val name: String? = null,
    val surname: String? = null,
    val bankNumber: String? = null,
    val bankCode: String? = null
) : MviState {
    val isBankNumberCorrect: Boolean
        get() = (bankNumber == null) || (bankNumber.isDigitsOnly() && bankNumber.length == 16)
    val isBankCodeCorrect: Boolean
        get() = (bankCode == null) || (bankCode.isDigitsOnly() && bankCode.isNotEmpty())
    val isNameCorrect: Boolean
        get() = (name == null) || (name.matches(Regex("^[A-Za-z\\s]+\$")))
    val isSurnameCorrect: Boolean
        get() = (surname == null) || (surname.matches(Regex("^[A-Za-z\\s]+\$")))
    val isButtonEnabled: Boolean
        get() = isBankNumberCorrect && isBankCodeCorrect && isNameCorrect && isSurnameCorrect
                && bankNumber != null && bankCode != null && name != null && surname != null

}

sealed interface RegisterAction : MviAction {
    data object GoFurther : RegisterAction
    data class OnBankNumberChange(val number: String) : RegisterAction
    data class OnBankCodeChange(val code: String) : RegisterAction
    data class OnNameChange(val name: String) : RegisterAction
    data class OnSurnameChange(val surname: String) : RegisterAction
}

sealed interface RegisterEffect : MviEffect {
    data object GoFurther : RegisterEffect
}