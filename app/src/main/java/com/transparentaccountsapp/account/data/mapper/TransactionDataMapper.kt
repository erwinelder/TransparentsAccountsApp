package com.transparentaccountsapp.account.data.mapper

import com.transparentaccountsapp.account.data.model.transaction.TransactionAmountDataModel
import com.transparentaccountsapp.account.data.model.transaction.TransactionDataModel
import com.transparentaccountsapp.account.data.model.transaction.TransactionReceiverDataModel
import com.transparentaccountsapp.account.data.model.transaction.TransactionSenderDataModel
import com.transparentaccountsapp.account.data.remote.model.transaction.TransactionAmountDto
import com.transparentaccountsapp.account.data.remote.model.transaction.TransactionDto
import com.transparentaccountsapp.account.data.remote.model.transaction.TransactionReceiverDto
import com.transparentaccountsapp.account.data.remote.model.transaction.TransactionSenderDto
import kotlinx.datetime.LocalDateTime


fun TransactionAmountDto.toDataModel(): TransactionAmountDataModel {
    return TransactionAmountDataModel(
        value = value,
        precision = precision,
        currency = currency
    )
}

fun TransactionReceiverDto.toDataModel(): TransactionReceiverDataModel {
    return TransactionReceiverDataModel(
        accountNumber = accountNumber,
        bankCode = bankCode,
        iban = iban
    )
}

fun TransactionSenderDto.toDataModel(): TransactionSenderDataModel {
    return TransactionSenderDataModel(
        accountNumber = accountNumber,
        bankCode = bankCode,
        iban = iban,
        specificSymbol = specificSymbol,
        specificSymbolParty = specificSymbolParty,
        constantSymbol = constantSymbol
    )
}

fun TransactionDto.toDataModel(): TransactionDataModel {
    return TransactionDataModel(
        amount = amount.toDataModel(),
        type = type,
        dueDate = LocalDateTime.parse(dueDate),
        processingDate = LocalDateTime.parse(processingDate),
        sender = sender.toDataModel(),
        receiver = receiver.toDataModel(),
        typeDescription = typeDescription
    )
}
