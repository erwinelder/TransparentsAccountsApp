package com.transparentaccountsapp.account.domain.model.transaction

data class TransactionSender(
    val accountNumber: String,
    val bankCode: String,
    val iban: String,
    val specificSymbol: String? = null,
    val specificSymbolParty: String? = null,
    val constantSymbol: String? = null
)
