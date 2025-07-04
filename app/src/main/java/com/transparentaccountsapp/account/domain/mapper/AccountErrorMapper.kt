package com.transparentaccountsapp.account.domain.mapper

import com.transparentaccountsapp.R
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState


fun AccountError.toResultState(): ResultState.ErrorState {
    return when (this) {
        AccountError.AccountsFetchError -> ResultState.ErrorState(
            titleRes = R.string.general_fetch_error_title,
            messageRes = R.string.accounts_fetch_error_message,
            buttonTextRes = R.string.try_again
        )
        AccountError.AccountFetchError -> ResultState.ErrorState(
            titleRes = R.string.general_fetch_error_title,
            messageRes = R.string.account_fetch_error_message,
            buttonTextRes = R.string.try_again
        )
        AccountError.AccountNotFoundError -> ResultState.ErrorState(
            titleRes = R.string.account_not_found_error_title,
            messageRes = null,
            buttonTextRes = null
        )
        AccountError.AccountTransactionsFetchError -> ResultState.ErrorState(
            titleRes = R.string.general_fetch_error_title,
            messageRes = R.string.account_transactions_fetch_error_message,
            buttonTextRes = R.string.try_again
        )
    }
}