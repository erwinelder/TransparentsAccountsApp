package com.transparentaccountsapp.core.presentation.screenContainer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.transparentaccountsapp.core.presentation.component.button.GlassSurfaceNavigationButton
import com.transparentaccountsapp.core.presentation.utils.plus

@Composable
fun ScreenContainerWithTopBackNavButton(
    screenPadding: PaddingValues = PaddingValues(),
    verticalGap: Dp = 24.dp,
    bottomPadding: Dp = 16.dp,
    backNavButtonText: String,
    onBackNavButtonClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalGap),
        modifier = Modifier
            .fillMaxSize()
            .padding(
                paddingValues = screenPadding + PaddingValues(top = 8.dp, bottom = bottomPadding)
            )
    ) {

        GlassSurfaceNavigationButton(
            text = backNavButtonText,
            onClick = onBackNavButtonClick
        )

        content()

    }
}