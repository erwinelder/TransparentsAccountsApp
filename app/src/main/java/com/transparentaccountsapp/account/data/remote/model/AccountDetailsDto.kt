package com.transparentaccountsapp.account.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class AccountDetailsDto(
    val accountNumber: String,
    val bankCode: String,
    val transparencyFrom: String,
    val transparencyTo: String,
    val publicationTo: String,
    val actualizationDate: String,
    val balance: Double,
    val currency: String?,
    val name: String,
    val description: String?,
    val iban: String,
    val statements: List<String>
)
