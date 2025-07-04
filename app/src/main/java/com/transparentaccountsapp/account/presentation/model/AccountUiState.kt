package com.transparentaccountsapp.account.presentation.model

data class AccountUiState(
    val accountNumber: String = "",
    val name: String = "N/A",
    val balance: String = "0.00",
    val currency: String? = null
)
