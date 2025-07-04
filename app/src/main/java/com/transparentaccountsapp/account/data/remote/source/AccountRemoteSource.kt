package com.transparentaccountsapp.account.data.remote.source

import com.transparentaccountsapp.account.data.remote.model.AccountDetailsDto
import com.transparentaccountsapp.account.data.remote.model.AccountDto
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

interface AccountRemoteSource {

    suspend fun getAllAccounts(): ResultData<List<AccountDto>, AccountError>

    suspend fun getAccountDetails(accountNumber: String): ResultData<AccountDetailsDto, AccountError>

}