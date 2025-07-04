package com.transparentaccountsapp.account.domain.model

import kotlinx.datetime.LocalDateTime

data class Account(
    val accountNumber: String,
    val bankCode: String,
    val transparencyFrom: LocalDateTime,
    val transparencyTo: LocalDateTime,
    val publicationTo: LocalDateTime,
    val actualizationDate: LocalDateTime,
    val balance: Double,
    val currency: String?,
    val name: String,
    val iban: String
)
