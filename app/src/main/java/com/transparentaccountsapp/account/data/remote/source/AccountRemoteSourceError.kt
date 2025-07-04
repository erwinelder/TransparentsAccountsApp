package com.transparentaccountsapp.account.data.remote.source

import com.transparentaccountsapp.account.data.remote.model.AccountDto
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.requestHandling.domain.model.ResultData
import kotlinx.coroutines.delay

class AccountRemoteSourceError : AccountRemoteSource {

    override suspend fun getAllAccounts(): ResultData<List<AccountDto>, AccountError> {
        delay(500)
        return ResultData.Error(error = AccountError.AccountsFetchError)
    }

}