package com.transparentaccountsapp.account.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.transparentaccountsapp.R
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.mapper.toResultState
import com.transparentaccountsapp.account.domain.usecase.GetAccountDetailsUseCase
import com.transparentaccountsapp.account.domain.usecase.GetAccountTransactionUseCase
import com.transparentaccountsapp.account.mapper.toUiState
import com.transparentaccountsapp.account.presentation.model.AccountDetailsUiState
import com.transparentaccountsapp.account.presentation.model.TransactionUiState
import com.transparentaccountsapp.requestHandling.domain.model.ResultData
import com.transparentaccountsapp.requestHandling.presentation.model.RequestState
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState.DataState
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState.ErrorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private typealias AccountRequestStateDataType = DataState<AccountDetailsUiState>
typealias AccountRequestStateType = RequestState<AccountRequestStateDataType, ErrorState>

private typealias TransactionsRequestStateDataType = DataState<List<TransactionUiState>>
typealias TransactionsRequestStateType = RequestState<TransactionsRequestStateDataType, ErrorState>

class AccountDetailsViewModel(
    private val accountNumber: String,
    private val getAccountDetailsUseCase: GetAccountDetailsUseCase,
    private val getAccountTransactionUseCase: GetAccountTransactionUseCase
) : ViewModel() {

    private val _accountRequestState = MutableStateFlow<AccountRequestStateType>(
        RequestState.Result(resultState = DataState(data = AccountDetailsUiState()))
    )
    val accountRequestState = _accountRequestState.asStateFlow()

    private fun setAccountRequestLoadingState() {
        _accountRequestState.update {
            RequestState.Loading(messageRes = R.string.account_loader_message)
        }
    }

    private fun setAccountRequestResultDataState(data: AccountDetailsUiState) {
        _accountRequestState.update {
            RequestState.Result(resultState = DataState(data = data))
        }
    }

    private fun setAccountRequestErrorState(error: AccountError) {
        _accountRequestState.update {
            RequestState.Error(errorState = error.toResultState())
        }
    }


    fun fetchAccount() {
        if (_accountRequestState.value is RequestState.Loading) return

        viewModelScope.launch {
            setAccountRequestLoadingState()

            val result = getAccountDetailsUseCase.execute(accountNumber = accountNumber)

            when (result) {
                is ResultData.Success -> {
                    setAccountRequestResultDataState(data = result.data.toUiState())
                }
                is ResultData.Error -> {
                    setAccountRequestErrorState(error = result.error)
                }
            }
        }
    }


    private val _transactionsRequestState = MutableStateFlow<TransactionsRequestStateType>(
        RequestState.Result(resultState = DataState(data = emptyList()))
    )
    val transactionsRequestState = _transactionsRequestState.asStateFlow()

    private fun setTransactionsRequestLoadingState() {
        _transactionsRequestState.update {
            RequestState.Loading(messageRes = R.string.account_loader_message)
        }
    }

    private fun setTransactionsRequestResultDataState(data: List<TransactionUiState>) {
        _transactionsRequestState.update {
            RequestState.Result(resultState = DataState(data = data))
        }
    }

    private fun setTransactionsRequestErrorState(error: AccountError) {
        _transactionsRequestState.update {
            RequestState.Error(errorState = error.toResultState())
        }
    }


    fun fetchAccountTransactions() {
        if (_transactionsRequestState.value is RequestState.Loading) return

        viewModelScope.launch {
            setTransactionsRequestLoadingState()

            val result = getAccountTransactionUseCase.execute(accountNumber = accountNumber)

            when (result) {
                is ResultData.Success -> {
                    setTransactionsRequestResultDataState(
                        data = result.data.map { it.toUiState() }
                    )
                }
                is ResultData.Error -> {
                    setTransactionsRequestErrorState(error = result.error)
                }
            }
        }
    }


    init {
        fetchAccount()
        fetchAccountTransactions()
    }

}