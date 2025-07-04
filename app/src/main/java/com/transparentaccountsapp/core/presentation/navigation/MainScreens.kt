package com.transparentaccountsapp.core.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface MainScreens {

    @Serializable
    data object Accounts : MainScreens

}