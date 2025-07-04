package com.transparentaccountsapp.account.domain.usecase

import com.transparentaccountsapp.account.data.repository.AccountRepository
import com.transparentaccountsapp.account.domain.model.Account
import com.transparentaccountsapp.account.mapper.toDomainModel

class GetAllAccountsUseCaseImpl(
    private val accountRepository: AccountRepository
) : GetAllAccountsUseCase {

    override suspend fun execute(): List<Account> {
        return accountRepository.getAllAccounts().map { it.toDomainModel() }
    }

}