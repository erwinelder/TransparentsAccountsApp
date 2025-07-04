package com.transparentaccountsapp.account.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7_PRO
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.transparentaccountsapp.account.presentation.model.AccountUiState
import com.transparentaccountsapp.core.domain.AppTheme
import com.transparentaccountsapp.core.domain.FilledWidthByScreenType
import com.transparentaccountsapp.core.presentation.preview.PreviewContainer
import com.transparentaccountsapp.core.presentation.theme.AppColors
import com.transparentaccountsapp.core.presentation.theme.CurrWindowType

@Composable
fun AccountComponent(
    uiState: AccountUiState
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .shadow(
                elevation = 10.dp
            )
            .background(AppColors.surface)
            .fillMaxWidth(
                FilledWidthByScreenType(.8f, .6f, .4f).getByType(CurrWindowType)
            )
    ) {
        Text(
            text = uiState.name,
            color = AppColors.onSurface,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = uiState.balance,
                color = AppColors.onSurface,
                fontSize = 18.sp
            )
            uiState.currency?.let {
                Text(
                    text = it,
                    color = AppColors.onSurface,
                    fontSize = 18.sp
                )
            }
        }
    }
}


@Preview(device = PIXEL_7_PRO)
@Composable
fun AccountComponentPreview() {
    PreviewContainer(appTheme = AppTheme.Light) {
        AccountComponent(
            uiState = AccountUiState(
                name = "Sample Account",
                balance = "1000.0",
                currency = "CZK",
            )
        )
    }
}