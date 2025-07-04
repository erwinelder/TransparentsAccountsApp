package com.transparentaccountsapp.account.data.model

import kotlinx.datetime.LocalDateTime

data class AccountDetailsDataModel(
    val accountNumber: String,
    val bankCode: String,
    val transparencyFrom: LocalDateTime,
    val transparencyTo: LocalDateTime,
    val publicationTo: LocalDateTime,
    val actualizationDate: LocalDateTime,
    val balance: Double,
    val currency: String?,
    val name: String,
    val description: String?,
    val iban: String,
    val statements: List<String>
)
