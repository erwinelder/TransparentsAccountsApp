package com.transparentaccountsapp.account.domain.usecase

import com.transparentaccountsapp.account.data.repository.AccountRepository
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.model.transaction.Transaction
import com.transparentaccountsapp.account.mapper.toDomainModel
import com.transparentaccountsapp.requestHandling.domain.model.ResultData

class GetAccountTransactionUseCaseImpl(
    private val accountRepository: AccountRepository
) : GetAccountTransactionUseCase {

    override suspend fun execute(
        accountNumber: String
    ): ResultData<List<Transaction>, AccountError> {
        return accountRepository.getAccountTransactions(accountNumber = accountNumber)
            .mapData { transactions ->
                transactions.map { it.toDomainModel() }
            }
    }

}