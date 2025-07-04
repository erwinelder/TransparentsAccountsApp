package com.transparentaccountsapp.account.domain.usecase

import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.model.AccountDetails
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

interface GetAccountDetailsUseCase {

    suspend fun execute(accountNumber: String): ResultData<AccountDetails, AccountError>

}