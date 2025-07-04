package com.transparentaccountsapp.account.data.remote.model.transaction

import kotlinx.serialization.Serializable

@Serializable
data class TransactionSenderDto(
    val accountNumber: String,
    val bankCode: String,
    val iban: String,
    val specificSymbol: String? = null,
    val specificSymbolParty: String? = null,
    val constantSymbol: String? = null
)
