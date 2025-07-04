package com.transparentaccountsapp.account.presentation.model

data class TransactionUiState(
    val amount: String = "0.00",
    val currency: String = "CZK",
    val processingDate: String = "",
    val senderAccountNumber: String = "",
    val typeDescription: String? = null,
)
