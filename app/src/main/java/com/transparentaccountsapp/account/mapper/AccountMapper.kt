package com.transparentaccountsapp.account.mapper

import com.transparentaccountsapp.account.data.model.AccountDataModel
import com.transparentaccountsapp.account.data.model.AccountDetailsDataModel
import com.transparentaccountsapp.account.domain.model.Account
import com.transparentaccountsapp.account.domain.model.AccountDetails
import com.transparentaccountsapp.account.presentation.model.AccountDetailsUiState
import com.transparentaccountsapp.account.presentation.model.AccountUiState


fun AccountDataModel.toDomainModel(): Account {
    return Account(
        accountNumber = accountNumber,
        bankCode = bankCode,
        transparencyFrom = transparencyFrom,
        transparencyTo = transparencyTo,
        publicationTo = publicationTo,
        actualizationDate = actualizationDate,
        balance = balance,
        currency = currency,
        name = name,
        description = description,
        iban = iban
    )
}

fun AccountDetailsDataModel.toDomainModel(): AccountDetails {
    return AccountDetails(
        accountNumber = accountNumber,
        bankCode = bankCode,
        transparencyFrom = transparencyFrom,
        transparencyTo = transparencyTo,
        publicationTo = publicationTo,
        actualizationDate = actualizationDate,
        balance = balance,
        currency = currency,
        name = name,
        description = description,
        iban = iban,
        statements = statements
    )
}


fun Account.toUiState(): AccountUiState {
    return AccountUiState(
        number = accountNumber,
        name = name,
        balance = balance.toString(),
        currency = currency
    )
}

fun AccountDetails.toUiState(): AccountDetailsUiState {
    return AccountDetailsUiState(
        number = accountNumber,
        name = name,
        balance = balance.toString(),
        currency = currency,
        description = description
    )
}
