package com.transparentaccountsapp.account.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class AccountsResponseDto(
    val pageNumber: Int,
    val pageSize: Int,
    val pageCount: Int,
    val nextPage: Int,
    val recordCount: Int,
    val accounts: List<AccountDto>
)
