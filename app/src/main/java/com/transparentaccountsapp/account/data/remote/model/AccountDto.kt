package com.transparentaccountsapp.account.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class AccountDto(
    val accountNumber: String,
    val bankCode: String,
    val transparencyFrom: String,
    val transparencyTo: String,
    val publicationTo: String,
    val actualizationDate: String,
    val balance: Double,
    val currency: String? = null,
    val name: String,
    val description: String? = null,
    val iban: String
)
