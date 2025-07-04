package com.transparentaccountsapp.account.domain.model.transaction

data class TransactionAmount(
    val value: Double,
    val precision: Int,
    val currency: String
)
