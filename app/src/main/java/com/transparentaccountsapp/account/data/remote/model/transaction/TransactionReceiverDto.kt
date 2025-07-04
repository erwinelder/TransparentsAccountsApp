package com.transparentaccountsapp.account.data.remote.model.transaction

import kotlinx.serialization.Serializable

@Serializable
data class TransactionReceiverDto(
    val accountNumber: String,
    val bankCode: String,
    val iban: String
)
