package com.transparentaccountsapp.account.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.transparentaccountsapp.R
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.mapper.toResultState
import com.transparentaccountsapp.account.domain.usecase.GetAccountDetailsUseCase
import com.transparentaccountsapp.account.mapper.toUiState
import com.transparentaccountsapp.account.presentation.model.AccountDetailsUiState
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

class AccountDetailsViewModel(
    private val accountNumber: String,
    private val getAccountDetailsUseCase: GetAccountDetailsUseCase
) : ViewModel() {

    private val _accountRequestState = MutableStateFlow<AccountRequestStateType>(
        RequestState.Result(resultState = DataState(data = AccountDetailsUiState()))
    )
    val accountRequestState = _accountRequestState.asStateFlow()

    private fun setRequestLoadingState() {
        _accountRequestState.update {
            RequestState.Loading(messageRes = R.string.account_loader_message)
        }
    }

    private fun setRequestResultDataState(data: AccountDetailsUiState) {
        _accountRequestState.update {
            RequestState.Result(resultState = DataState(data = data))
        }
    }

    private fun setRequestErrorState(error: AccountError) {
        _accountRequestState.update {
            RequestState.Error(errorState = error.toResultState())
        }
    }

    fun resetRequestState() {
        _accountRequestState.update {
            RequestState.Result(resultState = DataState(data = AccountDetailsUiState()))
        }
    }


    fun fetchAccount() {
        if (_accountRequestState.value is RequestState.Loading) return

        viewModelScope.launch {
            setRequestLoadingState()

            val result = getAccountDetailsUseCase.execute(accountNumber = accountNumber)

            when (result) {
                is ResultData.Success -> {
                    setRequestResultDataState(data = result.data.toUiState())
                }
                is ResultData.Error -> {
                    setRequestErrorState(error = result.error)
                }
            }
        }
    }


    init {
        fetchAccount()
    }

}