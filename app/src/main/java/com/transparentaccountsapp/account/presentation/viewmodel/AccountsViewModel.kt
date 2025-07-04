package com.transparentaccountsapp.account.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.transparentaccountsapp.account.domain.usecase.GetAllAccountsUseCase
import com.transparentaccountsapp.account.mapper.toUiState
import com.transparentaccountsapp.account.presentation.model.AccountUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AccountsViewModel(
    private val getAllAccountsUseCase: GetAllAccountsUseCase
) : ViewModel() {

    private val _accounts = MutableStateFlow<List<AccountUiState>>(emptyList())
    val accounts = _accounts.asStateFlow()

    fun fetchAccounts() {
        viewModelScope.launch {
            val accounts = getAllAccountsUseCase.execute().map { it.toUiState() }
            _accounts.update { accounts }
        }
    }

}