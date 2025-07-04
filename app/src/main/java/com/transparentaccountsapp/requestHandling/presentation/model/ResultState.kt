package com.transparentaccountsapp.requestHandling.presentation.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Stable

sealed class ResultState {

    @Stable
    data class DataState<T>(val data: T) : ResultState()

    @Stable
    data class ErrorState(
        @StringRes val titleRes: Int,
        @StringRes val messageRes: Int?,
        @StringRes val buttonTextRes: Int?
    ) : ResultState()

}