package com.transparentaccountsapp.account.domain.usecase

import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.model.transaction.Transaction
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

interface GetAccountTransactionUseCase {

    suspend fun execute(accountNumber: String): ResultData<List<Transaction>, AccountError>

}