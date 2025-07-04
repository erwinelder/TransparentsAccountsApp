package com.transparentaccountsapp.account.mapper

import com.transparentaccountsapp.account.data.model.AccountDataModel
import com.transparentaccountsapp.account.domain.model.Account
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
        iban = iban
    )
}


fun Account.toUiState(): AccountUiState {
    return AccountUiState(
        accountNumber = accountNumber,
        name = name,
        balance = balance.toString(),
        currency = currency
    )
}