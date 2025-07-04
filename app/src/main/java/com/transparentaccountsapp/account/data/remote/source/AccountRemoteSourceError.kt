package com.transparentaccountsapp.account.data.remote.source

import com.transparentaccountsapp.account.data.remote.model.AccountDetailsDto
import com.transparentaccountsapp.account.data.remote.model.AccountDto
import com.transparentaccountsapp.account.data.remote.model.transaction.TransactionDto
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.requestHandling.domain.model.ResultData
import kotlinx.coroutines.delay

class AccountRemoteSourceError : AccountRemoteSource {

    override suspend fun getAllAccounts(): ResultData<List<AccountDto>, AccountError> {
        delay(500)
        return ResultData.Error(error = AccountError.AccountsFetchError)
    }

    override suspend fun getAccountDetails(
        accountNumber: String
    ): ResultData<AccountDetailsDto, AccountError> {
        delay(500)
        return ResultData.Error(error = AccountError.AccountFetchError)
    }

    override suspend fun getAccountTransactions(
        accountNumber: String
    ): ResultData<List<TransactionDto>, AccountError> {
        delay(500)
        return ResultData.Error(error = AccountError.AccountTransactionsFetchError)
    }

}