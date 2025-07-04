package com.transparentaccountsapp.account.data.mapper

import com.transparentaccountsapp.account.data.model.AccountDataModel
import com.transparentaccountsapp.account.data.model.AccountDetailsDataModel
import com.transparentaccountsapp.account.data.remote.model.AccountDetailsDto
import com.transparentaccountsapp.account.data.remote.model.AccountDto
import kotlinx.datetime.LocalDateTime


fun AccountDto.toDataModel(): AccountDataModel {
    return AccountDataModel(
        accountNumber = accountNumber,
        bankCode = bankCode,
        transparencyFrom = LocalDateTime.parse(transparencyFrom),
        transparencyTo = LocalDateTime.parse(transparencyTo),
        publicationTo = LocalDateTime.parse(publicationTo),
        actualizationDate = LocalDateTime.parse(actualizationDate),
        balance = balance,
        currency = currency,
        name = name,
        description = description,
        iban = iban
    )
}

fun AccountDetailsDto.toDataModel(): AccountDetailsDataModel {
    return AccountDetailsDataModel(
        accountNumber = accountNumber,
        bankCode = bankCode,
        transparencyFrom = LocalDateTime.parse(transparencyFrom),
        transparencyTo = LocalDateTime.parse(transparencyTo),
        publicationTo = LocalDateTime.parse(publicationTo),
        actualizationDate = LocalDateTime.parse(actualizationDate),
        balance = balance,
        currency = currency,
        name = name,
        description = description,
        iban = iban,
        statements = statements
    )
}
