package com.transparentaccountsapp.account.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.transparentaccountsapp.account.presentation.component.TransactionComponent
import com.transparentaccountsapp.account.presentation.model.AccountDetailsUiState
import com.transparentaccountsapp.account.presentation.model.TransactionUiState
import com.transparentaccountsapp.account.presentation.viewmodel.AccountDetailsViewModel
import com.transparentaccountsapp.account.presentation.viewmodel.AccountRequestStateType
import com.transparentaccountsapp.account.presentation.viewmodel.TransactionsRequestStateType
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
    val transactionsRequestState by viewModel.transactionsRequestState.collectAsStateWithLifecycle()

    AccountDetailsScreen(
        screenPadding = screenPadding,
        onNavigateBack = onNavigateBack,
        accountRequestState = accountRequestState,
        transactionsRequestState = transactionsRequestState,
        errorAction = viewModel::fetchAccount
    )
}

@Composable
fun AccountDetailsScreen(
    screenPadding: PaddingValues = PaddingValues(),
    onNavigateBack: () -> Unit,
    accountRequestState: AccountRequestStateType,
    transactionsRequestState: TransactionsRequestStateType,
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

            AnimatedContentWithRequestState(
                requestDataState = transactionsRequestState,
                errorAction = errorAction,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { transactions ->
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(items = transactions) { transaction ->
                        TransactionComponent(uiState = transaction)
                    }
                }
            }

        }
    }
}


@Preview(device = PIXEL_7_PRO)
@Composable
fun AccountDetailsScreenPreview() {
    val accountRequestDataState: AccountRequestStateType = RequestState.Result(
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
    val transactionsRequestDataState: TransactionsRequestStateType = RequestState.Result(
        resultState = ResultState.DataState(
            data = listOf(
                TransactionUiState(
                    amount = "100.00",
                    currency = "CZK",
                    processingDate = "01.10.2023",
                    senderAccountNumber = "1234567890",
                    typeDescription = "Payment for services"
                ),
                TransactionUiState(
                    amount = "200.00",
                    currency = "CZK",
                    processingDate = "02.10.2023",
                    senderAccountNumber = "0987654321",
                    typeDescription = "Refund for returned goods"
                ),
                TransactionUiState(
                    amount = "50.00",
                    currency = "CZK",
                    processingDate = "03.10.2023",
                    senderAccountNumber = "1122334455",
                    typeDescription = "Transfer to savings account"
                )
            )
        )
    )

    PreviewContainer {
        AccountDetailsScreen(
            onNavigateBack = {},
            accountRequestState = accountRequestDataState,
            transactionsRequestState = transactionsRequestDataState,
            errorAction = {}
        )
    }
}