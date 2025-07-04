package com.transparentaccountsapp.account.data.remote.source

import com.transparentaccountsapp.account.data.remote.model.AccountDto

interface AccountRemoteSource {

    suspend fun getAllAccounts(): List<AccountDto>

}