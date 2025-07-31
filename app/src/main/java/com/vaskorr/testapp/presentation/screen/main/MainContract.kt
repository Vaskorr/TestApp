package com.vaskorr.testapp.presentation.screen.main

import com.vaskorr.testapp.domain.model.User
import com.vaskorr.testapp.presentation.util.MviAction
import com.vaskorr.testapp.presentation.util.MviEffect
import com.vaskorr.testapp.presentation.util.MviState

data class MainScreenState(
    val user: User? = null,
) : MviState

sealed interface MainAction : MviAction

sealed interface MainEffect : MviEffect