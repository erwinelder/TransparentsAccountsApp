package com.transparentaccountsapp.account.domain.error

import com.transparentaccountsapp.requestHandling.domain.model.Error

enum class AccountError : Error {
    AccountsFetchError,
    AccountFetchError,
    AccountNotFoundError,
    AccountTransactionsFetchError
}