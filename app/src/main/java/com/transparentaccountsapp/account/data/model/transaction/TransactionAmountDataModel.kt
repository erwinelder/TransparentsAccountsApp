package com.transparentaccountsapp.account.data.model.transaction

data class TransactionAmountDataModel(
    val value: Double,
    val precision: Int,
    val currency: String
)
