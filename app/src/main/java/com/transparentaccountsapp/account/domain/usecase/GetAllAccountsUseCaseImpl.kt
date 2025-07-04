package com.transparentaccountsapp.account.domain.usecase

import com.transparentaccountsapp.account.data.repository.AccountRepository
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.model.Account
import com.transparentaccountsapp.account.mapper.toDomainModel
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

class GetAllAccountsUseCaseImpl(
    private val accountRepository: AccountRepository
) : GetAllAccountsUseCase {

    override suspend fun execute(): ResultData<List<Account>, AccountError> {
        return accountRepository.getAllAccounts().mapData { accounts ->
            accounts.map { it.toDomainModel() }
        }
    }

}