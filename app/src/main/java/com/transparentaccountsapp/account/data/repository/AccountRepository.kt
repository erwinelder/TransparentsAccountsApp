package com.transparentaccountsapp.account.data.repository

import com.transparentaccountsapp.account.data.model.AccountDataModel
import com.transparentaccountsapp.account.data.model.AccountDetailsDataModel
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

interface AccountRepository {

    suspend fun getAllAccounts(): ResultData<List<AccountDataModel>, AccountError>

    suspend fun getAccountDetails(
        accountNumber: String
    ): ResultData<AccountDetailsDataModel, AccountError>

}