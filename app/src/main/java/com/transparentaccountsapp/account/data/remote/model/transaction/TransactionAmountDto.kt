package com.transparentaccountsapp.account.data.remote.model.transaction

import kotlinx.serialization.Serializable

@Serializable
data class TransactionAmountDto(
    val value: Double,
    val precision: Int,
    val currency: String
)
