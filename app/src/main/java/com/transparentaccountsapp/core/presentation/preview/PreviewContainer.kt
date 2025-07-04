package com.transparentaccountsapp.core.presentation.preview

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.transparentaccountsapp.core.domain.AppTheme
import com.transparentaccountsapp.core.presentation.theme.AppColors
import com.transparentaccountsapp.core.presentation.theme.TransparentAccountsAppTheme

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PreviewContainer(
    appTheme: AppTheme = AppTheme.Light,
    content: @Composable BoxScope.() -> Unit
) {
    BoxWithConstraints {
        TransparentAccountsAppTheme(
            boxWithConstraintsScope = this,
            appTheme = appTheme
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = AppColors.background)
                )
                content()
            }
        }
    }
}