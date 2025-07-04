package com.transparentaccountsapp.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.transparentaccountsapp.core.presentation.component.other.AppBackground
import com.transparentaccountsapp.core.presentation.navigation.AppNavHost
import com.transparentaccountsapp.core.presentation.screenContainer.MainScaffold
import com.transparentaccountsapp.core.presentation.theme.TransparentAccountsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            BoxWithConstraints {
                TransparentAccountsAppTheme(
                    boxWithConstraintsScope = this
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    Box(modifier = Modifier.fillMaxSize()) {
                        AppBackground()
                        MainScaffold(
                            navController = navController,
                            navBackStackEntry = navBackStackEntry
                        ) { scaffoldPadding ->
                            AppNavHost(
                                screenPadding = scaffoldPadding,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}