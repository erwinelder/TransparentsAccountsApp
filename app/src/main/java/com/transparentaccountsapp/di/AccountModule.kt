package com.transparentaccountsapp.di

import com.transparentaccountsapp.account.data.remote.source.AccountRemoteSource
import com.transparentaccountsapp.account.data.remote.source.AccountRemoteSourceImpl
import com.transparentaccountsapp.account.data.repository.AccountRepository
import com.transparentaccountsapp.account.data.repository.AccountRepositoryImpl
import com.transparentaccountsapp.account.domain.usecase.GetAccountDetailsUseCase
import com.transparentaccountsapp.account.domain.usecase.GetAccountDetailsUseCaseImpl
import com.transparentaccountsapp.account.domain.usecase.GetAccountTransactionUseCase
import com.transparentaccountsapp.account.domain.usecase.GetAccountTransactionUseCaseImpl
import com.transparentaccountsapp.account.domain.usecase.GetAllAccountsUseCase
import com.transparentaccountsapp.account.domain.usecase.GetAllAccountsUseCaseImpl
import com.transparentaccountsapp.account.presentation.viewmodel.AccountDetailsViewModel
import com.transparentaccountsapp.account.presentation.viewmodel.AccountsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val accountModule = module {

    /* Remote Source */

    single<AccountRemoteSource> {
        AccountRemoteSourceImpl()
//        AccountRemoteSourceError() // Uncomment to simulate error
    }

    /* Repository */

    single<AccountRepository> {
        AccountRepositoryImpl(remoteSource = get())
    }

    /* Use Case */

    single<GetAllAccountsUseCase> {
        GetAllAccountsUseCaseImpl(accountRepository = get())
    }

    single<GetAccountDetailsUseCase> {
        GetAccountDetailsUseCaseImpl(accountRepository = get())
    }

    single<GetAccountTransactionUseCase> {
        GetAccountTransactionUseCaseImpl(accountRepository = get())
    }

    /* View Models */

    viewModel {
        AccountsViewModel(getAllAccountsUseCase = get())
    }

    viewModel { params ->
        AccountDetailsViewModel(
            accountNumber = params.get(),
            getAccountDetailsUseCase = get(),
            getAccountTransactionUseCase = get()
        )
    }

}