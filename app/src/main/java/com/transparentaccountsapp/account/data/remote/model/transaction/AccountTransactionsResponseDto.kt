package com.transparentaccountsapp.account.data.remote.model.transaction

import kotlinx.serialization.Serializable

@Serializable
data class AccountTransactionsResponseDto(
    val pageNumber: Int,
    val pageSize: Int,
    val pageCount: Int,
    val nextPage: Int,
    val recordCount: Int,
    val transactions: List<TransactionDto>
)