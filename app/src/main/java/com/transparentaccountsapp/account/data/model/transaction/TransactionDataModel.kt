package com.transparentaccountsapp.account.data.model.transaction

import kotlinx.datetime.LocalDateTime

data class TransactionDataModel(
    val amount: TransactionAmountDataModel,
    val type: String,
    val dueDate: LocalDateTime,
    val processingDate: LocalDateTime,
    val sender: TransactionSenderDataModel,
    val receiver: TransactionReceiverDataModel,
    val typeDescription: String? = null
)
