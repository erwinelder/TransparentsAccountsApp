package com.transparentaccountsapp.account.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import com.transparentaccountsapp.account.presentation.viewmodel.AccountsRequestStateType
import com.transparentaccountsapp.account.presentation.viewmodel.AccountsViewModel
import com.transparentaccountsapp.core.presentation.preview.PreviewContainer
import com.transparentaccountsapp.requestHandling.presentation.model.RequestState
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState
import com.transparentaccountsapp.requestHandling.presentation.screenContainer.AnimatedContentWithRequestState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AccountsScreenWrapper(
    screenPadding: PaddingValues = PaddingValues(),
    onNavigateToAccountDetailsScreen: (String) -> Unit
) {
    val viewModel = koinViewModel<AccountsViewModel>()

    val requestState by viewModel.accountsRequestState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.fetchAccounts()
    }

    AccountsScreen(
        screenPadding = screenPadding,
        accountsRequestState = requestState,
        errorAction = viewModel::fetchAccounts,
        onAccountClick = onNavigateToAccountDetailsScreen
    )
}

@Composable
fun AccountsScreen(
    screenPadding: PaddingValues = PaddingValues(),
    accountsRequestState: AccountsRequestStateType,
    errorAction: () -> Unit,
    onAccountClick: (String) -> Unit
) {
    AnimatedContentWithRequestState(
        screenPadding = screenPadding,
        requestDataState = accountsRequestState,
        errorAction = errorAction,
        modifier = Modifier.fillMaxSize()
    ) { accounts ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(screenPadding)
        ) {
            items(items = accounts) { account ->
                AccountComponent(
                    uiState = account,
                    onClick = onAccountClick
                )
            }
        }
    }
}


@Preview(device = PIXEL_7_PRO)
@Composable
fun AccountsScreenPreview() {
    val requestDataState: AccountsRequestStateType = RequestState.Result(
        resultState = ResultState.DataState(
            data = listOf(
                AccountUiState(),
                AccountUiState(),
            )
        )
    )

    PreviewContainer {
        AccountsScreen(
            accountsRequestState = requestDataState,
            errorAction = {},
            onAccountClick = {}
        )
    }
}