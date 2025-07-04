package com.transparentaccountsapp.account.domain.model.transaction

data class TransactionReceiver(
    val accountNumber: String,
    val bankCode: String,
    val iban: String
)
