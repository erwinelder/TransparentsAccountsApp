package com.transparentaccountsapp.account.data.remote.model.transaction

import kotlinx.serialization.Serializable

@Serializable
data class TransactionDto(
    val amount: TransactionAmountDto,
    val type: String,
    val dueDate: String,
    val processingDate: String,
    val sender: TransactionSenderDto,
    val receiver: TransactionReceiverDto,
    val typeDescription: String? = null
)
