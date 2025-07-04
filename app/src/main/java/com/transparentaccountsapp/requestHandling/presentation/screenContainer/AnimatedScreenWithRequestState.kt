package com.transparentaccountsapp.requestHandling.presentation.screenContainer

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.transparentaccountsapp.core.presentation.navigation.SetBackHandler
import com.transparentaccountsapp.requestHandling.presentation.component.LoadingStateComponent
import com.transparentaccountsapp.requestHandling.presentation.component.ResultErrorComponent
import com.transparentaccountsapp.requestHandling.presentation.model.RequestState
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState.DataState
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState.ErrorState

@Composable
fun <T> AnimatedScreenWithRequestState(
    screenPadding: PaddingValues = PaddingValues(),
    requestDataState: RequestState<DataState<T>, ErrorState>,
    errorAction: () -> Unit,
    screen: @Composable (T) -> Unit
) {
    SetBackHandler(enabled = requestDataState is RequestState.Loading) {}

    AnimatedContent(
        targetState = requestDataState,
        modifier = Modifier
            .fillMaxSize()
            .padding(screenPadding)
    ) { dataState ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            when (dataState) {
                is RequestState.Loading -> {
                    LoadingStateComponent(
                        message = stringResource(dataState.messageRes)
                    )
                }
                is RequestState.Result -> {
                    screen(dataState.resultState.data)
                }
                is RequestState.Error -> {
                    ResultErrorComponent(
                        errorState = dataState.errorState,
                        onButtonClick = errorAction
                    )
                }
            }
        }
    }
}