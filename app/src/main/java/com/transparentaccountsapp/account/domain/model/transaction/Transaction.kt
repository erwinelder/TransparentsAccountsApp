package com.transparentaccountsapp.account.domain.model.transaction

import kotlinx.datetime.LocalDateTime

data class Transaction(
    val amount: TransactionAmount,
    val type: String,
    val dueDate: LocalDateTime,
    val processingDate: LocalDateTime,
    val sender: TransactionSender,
    val receiver: TransactionReceiver,
    val typeDescription: String? = null
)
