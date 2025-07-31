package com.vaskorr.testapp.presentation.screen.purchases

import com.vaskorr.testapp.presentation.util.MviAction
import com.vaskorr.testapp.presentation.util.MviEffect
import com.vaskorr.testapp.presentation.util.MviState
import java.time.LocalDate

data class PurchasesScreenState(
    val purchasesData: Map<LocalDate, List<String>> = emptyMap()
) : MviState

sealed interface PurchasesAction : MviAction

sealed interface PurchasesEffect : MviEffect