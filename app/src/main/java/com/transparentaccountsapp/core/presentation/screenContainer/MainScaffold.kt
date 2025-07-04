package com.transparentaccountsapp.core.presentation.screenContainer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun MainScaffold(
    navController: NavController,
    navBackStackEntry: NavBackStackEntry?,
    content: @Composable (scaffoldPadding: PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            /*BottomNavBarWrapper(
                navViewModel = navViewModel,
                navController = navController,
                navBackStackEntry = navBackStackEntry
            )*/
        },
        containerColor = Color.Transparent
    ) { scaffoldPadding ->
        content(scaffoldPadding)
    }
}