package com.transparentaccountsapp.account.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7_PRO
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.toRoute
import com.transparentaccountsapp.R
import com.transparentaccountsapp.account.presentation.component.AccountDetailsComponent
import com.transparentaccountsapp.account.presentation.model.AccountDetailsUiState
import com.transparentaccountsapp.account.presentation.viewmodel.AccountDetailsViewModel
import com.transparentaccountsapp.account.presentation.viewmodel.AccountRequestStateType
import com.transparentaccountsapp.core.presentation.navigation.MainScreens
import com.transparentaccountsapp.core.presentation.preview.PreviewContainer
import com.transparentaccountsapp.core.presentation.screenContainer.ScreenContainerWithTopBackNavButton
import com.transparentaccountsapp.requestHandling.presentation.model.RequestState
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState
import com.transparentaccountsapp.requestHandling.presentation.screenContainer.AnimatedContentWithRequestState
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun AccountDetailsScreenWrapper(
    screenPadding: PaddingValues = PaddingValues(),
    backStack: NavBackStackEntry,
    onNavigateBack: () -> Unit
) {
    val accountNumber = backStack.toRoute<MainScreens.AccountDetails>().number

    val viewModel = koinViewModel<AccountDetailsViewModel> {
        parametersOf(accountNumber)
    }

    val accountRequestState by viewModel.accountRequestState.collectAsStateWithLifecycle()

    AccountDetailsScreen(
        screenPadding = screenPadding,
        onNavigateBack = onNavigateBack,
        accountRequestState = accountRequestState,
        errorAction = viewModel::fetchAccount
    )
}

@Composable
fun AccountDetailsScreen(
    screenPadding: PaddingValues = PaddingValues(),
    onNavigateBack: () -> Unit,
    accountRequestState: AccountRequestStateType,
    errorAction: () -> Unit,
) {
    ScreenContainerWithTopBackNavButton(
        screenPadding = screenPadding,
        backNavButtonText = stringResource(R.string.back),
        onBackNavButtonClick = onNavigateBack
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            AnimatedContentWithRequestState(
                screenPadding = screenPadding,
                requestDataState = accountRequestState,
                errorAction = errorAction,
                modifier = Modifier.fillMaxWidth()
            ) { account ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    AccountDetailsComponent(uiState = account)
                }
            }

        }
    }
}


@Preview(device = PIXEL_7_PRO)
@Composable
fun AccountDetailsScreenPreview() {
    val requestDataState: AccountRequestStateType = RequestState.Result(
        resultState = ResultState.DataState(
            data = AccountDetailsUiState(
                number = "1234567890",
                name = "Sample Account",
                balance = "1000.00",
                currency = "CZK",
                description = "Sample account description for preview purposes.",
            )
        )
    )

    PreviewContainer {
        AccountDetailsScreen(
            onNavigateBack = {},
            accountRequestState = requestDataState,
            errorAction = {}
        )
    }
}