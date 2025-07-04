package com.transparentaccountsapp.account.domain.usecase

import com.transparentaccountsapp.account.data.repository.AccountRepository
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.model.AccountDetails
import com.transparentaccountsapp.account.mapper.toDomainModel
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

class GetAccountDetailsUseCaseImpl(
    private val accountRepository: AccountRepository
) : GetAccountDetailsUseCase {

    override suspend fun execute(accountNumber: String): ResultData<AccountDetails, AccountError> {
            return accountRepository.getAccountDetails(accountNumber = accountNumber)
            .mapData { it.toDomainModel() }
    }

}