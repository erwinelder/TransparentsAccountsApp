package com.transparentaccountsapp.account.presentation.model

data class AccountUiState(
    val number: String = "",
    val name: String = "N/A",
    val balance: String = "0.00",
    val currency: String? = null
)
