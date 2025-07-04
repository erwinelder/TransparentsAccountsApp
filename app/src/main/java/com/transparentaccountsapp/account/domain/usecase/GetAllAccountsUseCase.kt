package com.transparentaccountsapp.account.domain.usecase

import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.model.Account
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

interface GetAllAccountsUseCase {

    suspend fun execute(): ResultData<List<Account>, AccountError>

}