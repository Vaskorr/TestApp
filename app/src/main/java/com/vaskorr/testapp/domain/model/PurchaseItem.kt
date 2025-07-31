package com.vaskorr.testapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PurchaseItem(
    val date: String,
    val name: List<String>
)