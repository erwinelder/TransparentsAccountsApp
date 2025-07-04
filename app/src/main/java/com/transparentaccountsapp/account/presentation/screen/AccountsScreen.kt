package com.transparentaccountsapp.account.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7_PRO
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.transparentaccountsapp.account.presentation.component.AccountComponent
import com.transparentaccountsapp.account.presentation.model.AccountUiState
import com.transparentaccountsapp.account.presentation.viewmodel.AccountsViewModel
import com.transparentaccountsapp.core.presentation.preview.PreviewContainer
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AccountsScreenWrapper(
    screenPadding: PaddingValues = PaddingValues()
) {
    val viewModel = koinViewModel<AccountsViewModel>()

    val accounts by viewModel.accounts.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.fetchAccounts()
    }

    AccountsScreen(
        screenPadding = screenPadding,
        accounts = accounts
    )
}

@Composable
fun AccountsScreen(
    screenPadding: PaddingValues = PaddingValues(),
    accounts: List<AccountUiState>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(screenPadding)
    ) {
        items(items = accounts) { account ->
            AccountComponent(
                uiState = account
            )
        }
    }
}


@Preview(device = PIXEL_7_PRO)
@Composable
fun AccountsScreenPreview() {
    PreviewContainer {
        AccountsScreen(
            accounts = listOf(
                AccountUiState(),
                AccountUiState(),
            )
        )
    }
}