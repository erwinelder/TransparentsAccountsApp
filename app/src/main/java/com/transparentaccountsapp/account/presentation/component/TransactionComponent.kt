package com.transparentaccountsapp.account.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.transparentaccountsapp.R
import com.transparentaccountsapp.account.presentation.model.TransactionUiState
import com.transparentaccountsapp.core.domain.FilledWidthByScreenType
import com.transparentaccountsapp.core.presentation.component.container.GlassSurface
import com.transparentaccountsapp.core.presentation.theme.AppColors
import com.transparentaccountsapp.core.presentation.theme.CurrWindowType

@Composable
fun TransactionComponent(
    uiState: TransactionUiState
) {
    GlassSurface(
        cornerSize = 12.dp,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(
                FilledWidthByScreenType().getByType(CurrWindowType)
            )
        ) {
            Text(
                text = uiState.processingDate,
                color = AppColors.onSurface,
                fontSize = 14.sp
            )
            uiState.typeDescription?.let {
                Text(
                    text = stringResource(R.string.description_placeholder, it),
                    color = AppColors.onSurface,
                    fontSize = 14.sp
                )
            }
            Text(
                text = stringResource(R.string.from_placeholder, uiState.senderAccountNumber),
                color = AppColors.onSurface,
                fontSize = 14.sp
            )
            Text(
                text = "${uiState.amount} ${uiState.currency}",
                color = AppColors.onSurface,
                fontSize = 16.sp
            )
        }
    }
}