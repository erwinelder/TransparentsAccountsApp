package com.transparentaccountsapp.account.data.repository

import com.transparentaccountsapp.account.data.mapper.toDataModel
import com.transparentaccountsapp.account.data.model.AccountDataModel
import com.transparentaccountsapp.account.data.model.AccountDetailsDataModel
import com.transparentaccountsapp.account.data.model.transaction.TransactionDataModel
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

    override suspend fun getAccountDetails(
        accountNumber: String
    ): ResultData<AccountDetailsDataModel, AccountError> {
        return remoteSource.getAccountDetails(accountNumber = accountNumber)
            .mapData { it.toDataModel() }
    }

    override suspend fun getAccountTransactions(
        accountNumber: String
    ): ResultData<List<TransactionDataModel>, AccountError> {
        return remoteSource.getAccountTransactions(accountNumber = accountNumber)
            .mapData { transactions ->
                transactions.map { it.toDataModel() }
            }
    }

}