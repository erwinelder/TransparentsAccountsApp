package com.transparentaccountsapp.requestHandling.presentation.model

import androidx.annotation.StringRes

sealed class RequestState <T : ResultState, E : ResultState> {

    data class Loading<T : ResultState, E : ResultState>(
        @StringRes val messageRes: Int
    ) : RequestState<T ,E>()

    data class Result<T : ResultState, E : ResultState>(
        val resultState: T
    ): RequestState<T, E>()

    data class Error<T : ResultState, E : ResultState>(
        val errorState: E
    ) : RequestState<T, E>()

}