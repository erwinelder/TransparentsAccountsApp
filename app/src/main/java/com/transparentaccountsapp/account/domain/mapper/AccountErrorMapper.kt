package com.transparentaccountsapp.account.domain.mapper

import com.transparentaccountsapp.R
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState


fun AccountError.toResultState(): ResultState.ErrorState {
    return when (this) {
        AccountError.AccountsFetchError -> ResultState.ErrorState(
            titleRes = R.string.general_fetch_error_title,
            messageRes = R.string.accounts_fetch_error_message,
            buttonTextRes = R.string.accounts_fetch_error_button
        )
    }
}