package com.transparentaccountsapp.account.data.repository

import com.transparentaccountsapp.account.data.mapper.toDataModel
import com.transparentaccountsapp.account.data.model.AccountDataModel
import com.transparentaccountsapp.account.data.remote.source.AccountRemoteSource
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

class AccountRepositoryImpl(
    private val remoteSource: AccountRemoteSource
) : AccountRepository {

    override suspend fun getAllAccounts(): ResultData<List<AccountDataModel>, AccountError> {
        return remoteSource.getAllAccounts().mapData { accounts ->
            accounts.map { it.toDataModel() }
        }
    }

}