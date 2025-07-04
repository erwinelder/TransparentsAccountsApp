package com.transparentaccountsapp.account.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.transparentaccountsapp.R
import com.transparentaccountsapp.account.domain.error.AccountError
import com.transparentaccountsapp.account.domain.mapper.toResultState
import com.transparentaccountsapp.account.domain.usecase.GetAllAccountsUseCase
import com.transparentaccountsapp.account.mapper.toUiState
import com.transparentaccountsapp.account.presentation.model.AccountUiState
import com.transparentaccountsapp.requestHandling.domain.model.ResultData
import com.transparentaccountsapp.requestHandling.presentation.model.RequestState
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState.DataState
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState.ErrorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private typealias RequestStateDataType = DataState<List<AccountUiState>>
typealias AccountsRequestStateType = RequestState<RequestStateDataType, ErrorState>

class AccountsViewModel(
    private val getAllAccountsUseCase: GetAllAccountsUseCase
) : ViewModel() {

    private val _requestState = MutableStateFlow<AccountsRequestStateType>(
        RequestState.Result(resultState = DataState(data = emptyList()))
    )
    val requestState = _requestState.asStateFlow()

    private fun setRequestLoadingState() {
        _requestState.update {
            RequestState.Loading(messageRes = R.string.accounts_loader_message)
        }
    }

    private fun setRequestResultDataState(data: List<AccountUiState>) {
        _requestState.update {
            RequestState.Result(resultState = DataState(data = data))
        }
    }

    private fun setRequestErrorState(error: AccountError) {
        _requestState.update {
            RequestState.Error(errorState = error.toResultState())
        }
    }

    fun resetRequestState() {
        _requestState.update {
            RequestState.Result(resultState = DataState(data = emptyList()))
        }
    }

    fun fetchAccounts() {
        if (_requestState.value is RequestState.Loading) return

        viewModelScope.launch {
            setRequestLoadingState()
            val result = getAllAccountsUseCase.execute()

            when (result) {
                is ResultData.Success -> {
                    setRequestResultDataState(data = result.data.map { it.toUiState() })
                }
                is ResultData.Error -> {
                    setRequestErrorState(error = result.error)
                }
            }
        }
    }

}