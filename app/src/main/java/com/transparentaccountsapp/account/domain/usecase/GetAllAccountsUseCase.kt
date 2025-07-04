package com.transparentaccountsapp.account.domain.usecase

import com.transparentaccountsapp.account.domain.model.Account

interface GetAllAccountsUseCase {

    suspend fun execute(): List<Account>

}