package com.vaskorr.testapp.presentation.screen.purchases

import androidx.lifecycle.viewModelScope
import com.vaskorr.testapp.domain.model.PurchaseList
import com.vaskorr.testapp.domain.usecase.data.GetPurchasesUseCase
import com.vaskorr.testapp.presentation.util.MviViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PurchasesViewModel(
    getPurchasesUseCase: GetPurchasesUseCase
) : MviViewModel<PurchasesScreenState, PurchasesAction, PurchasesEffect>(
    PurchasesScreenState()
) {
    override fun onAction(action: PurchasesAction) {}

    init {
        viewModelScope.launch {
            changeState {
                it.copy(
                    purchasesData = parsePurchasesData(
                        getPurchasesUseCase.invoke()
                    )
                )
            }
        }
    }

    private fun parsePurchasesData(data: PurchaseList): Map<LocalDate, List<String>> {
        val result: MutableMap<LocalDate, MutableList<String>> = mutableMapOf()
        data.data.forEach { datePurchasesItem ->
            val date = LocalDateTime.parse(datePurchasesItem.date, DateTimeFormatter.ISO_DATE_TIME)
                .toLocalDate()
            if (result[date] != null) {
                result[date]?.addAll(datePurchasesItem.name)
            } else {
                result[date] = datePurchasesItem.name.toMutableList()
            }
        }
        return result
    }


}