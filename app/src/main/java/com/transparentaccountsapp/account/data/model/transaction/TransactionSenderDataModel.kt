package com.transparentaccountsapp.account.data.model.transaction

data class TransactionSenderDataModel(
    val accountNumber: String,
    val bankCode: String,
    val iban: String,
    val specificSymbol: String? = null,
    val specificSymbolParty: String? = null,
    val constantSymbol: String? = null
)
