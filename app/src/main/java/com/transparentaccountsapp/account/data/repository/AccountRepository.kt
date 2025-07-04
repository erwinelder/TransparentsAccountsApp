package com.transparentaccountsapp.account.data.repository

import com.transparentaccountsapp.account.data.model.AccountDataModel

interface AccountRepository {

    suspend fun getAllAccounts(): List<AccountDataModel>

}