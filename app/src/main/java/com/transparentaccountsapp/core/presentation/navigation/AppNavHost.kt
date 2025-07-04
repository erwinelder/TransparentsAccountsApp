package com.transparentaccountsapp.core.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.transparentaccountsapp.account.presentation.screen.AccountsScreenWrapper

@Composable
fun AppNavHost(
    screenPadding: PaddingValues = PaddingValues(),
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MainScreens.Accounts,
        contentAlignment = Alignment.Center,
    ) {
        composable<MainScreens.Accounts> {
            AccountsScreenWrapper(
                screenPadding = screenPadding
            )
        }
    }
}