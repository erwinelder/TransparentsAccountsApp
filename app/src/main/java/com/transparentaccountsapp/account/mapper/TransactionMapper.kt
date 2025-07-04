package com.transparentaccountsapp.account.mapper

import com.transparentaccountsapp.account.data.model.transaction.TransactionAmountDataModel
import com.transparentaccountsapp.account.data.model.transaction.TransactionDataModel
import com.transparentaccountsapp.account.data.model.transaction.TransactionReceiverDataModel
import com.transparentaccountsapp.account.data.model.transaction.TransactionSenderDataModel
import com.transparentaccountsapp.account.domain.model.transaction.Transaction
import com.transparentaccountsapp.account.domain.model.transaction.TransactionAmount
import com.transparentaccountsapp.account.domain.model.transaction.TransactionReceiver
import com.transparentaccountsapp.account.domain.model.transaction.TransactionSender
import com.transparentaccountsapp.account.presentation.model.TransactionUiState
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.char


fun TransactionAmountDataModel.toDomainModel(): TransactionAmount {
    return TransactionAmount(
        value = value,
        precision = precision,
        currency = currency
    )
}

fun TransactionReceiverDataModel.toDomainModel(): TransactionReceiver {
    return TransactionReceiver(
        accountNumber = accountNumber,
        bankCode = bankCode,
        iban = iban
    )
}

fun TransactionSenderDataModel.toDomainModel(): TransactionSender {
    return TransactionSender(
        accountNumber = accountNumber,
        bankCode = bankCode,
        iban = iban,
        specificSymbol = specificSymbol,
        specificSymbolParty = specificSymbolParty,
        constantSymbol = constantSymbol
    )
}

fun TransactionDataModel.toDomainModel(): Transaction {
    return Transaction(
        amount = amount.toDomainModel(),
        type = type,
        dueDate = dueDate,
        processingDate = processingDate,
        sender = sender.toDomainModel(),
        receiver = receiver.toDomainModel(),
        typeDescription = typeDescription
    )
}


fun Transaction.toUiState(): TransactionUiState {
    return TransactionUiState(
        amount = amount.value.toString(),
        currency = amount.currency,
        processingDate = processingDate.format(
            format = LocalDateTime.Format {
                day(); char('.'); monthNumber(); char('.'); year()
            }
        ),
        senderAccountNumber = sender.accountNumber,
        typeDescription = typeDescription
    )
}
