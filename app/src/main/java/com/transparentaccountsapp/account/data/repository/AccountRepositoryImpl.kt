package com.transparentaccountsapp.account.data.repository

import com.transparentaccountsapp.account.data.mapper.toDataModel
import com.transparentaccountsapp.account.data.model.AccountDataModel
import com.transparentaccountsapp.account.data.remote.source.AccountRemoteSource

class AccountRepositoryImpl(
    private val remoteSource: AccountRemoteSource
) : AccountRepository {

    override suspend fun getAllAccounts(): List<AccountDataModel> {
        return remoteSource.getAllAccounts().map { it.toDataModel() }
    }

}