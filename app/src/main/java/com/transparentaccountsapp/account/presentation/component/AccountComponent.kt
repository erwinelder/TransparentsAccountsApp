package com.transparentaccountsapp.account.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.transparentaccountsapp.R
import com.transparentaccountsapp.account.presentation.model.AccountUiState
import com.transparentaccountsapp.core.domain.AppTheme
import com.transparentaccountsapp.core.domain.FilledWidthByScreenType
import com.transparentaccountsapp.core.presentation.modifier.bounceClickEffect
import com.transparentaccountsapp.core.presentation.preview.PreviewContainer
import com.transparentaccountsapp.core.presentation.theme.CurrAppTheme
import com.transparentaccountsapp.core.presentation.theme.CurrWindowType

@Composable
fun AccountComponent(
    uiState: AccountUiState,
    onClick: (String) -> Unit
) {
    val appTheme = CurrAppTheme
    val accountColor by remember {
        derivedStateOf {
            when (appTheme) {
                AppTheme.Light -> listOf(Color(32, 32, 32), Color(52, 52, 52))
                AppTheme.Dark -> listOf(Color(200, 200, 200), Color(220, 220, 220))
            }
        }
    }
    val onAccountColor by remember {
        derivedStateOf {
            when (appTheme) {
                AppTheme.Light -> Color(240, 240, 240)
                AppTheme.Dark -> Color(18, 18, 18)
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .bounceClickEffect {
                onClick(uiState.number)
            }
            .clip(RoundedCornerShape(30.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = accountColor,
                    start = Offset(-30f, 230f),
                    end = Offset(40f, -100f)
                )
            )
            .fillMaxWidth(FilledWidthByScreenType(.9f, .6f, .42f).getByType(CurrWindowType))
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(.96f)
        ) {
            Text(
                text = uiState.name,
                fontSize = 18.sp,
                color = onAccountColor,
                fontWeight = FontWeight.ExtraLight,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        BalanceRow(uiState, onAccountColor)
    }
}

@Composable
private fun BalanceRow(uiState: AccountUiState, onAccountColor: Color) {
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.balance),
            fontSize = 16.sp,
            color = onAccountColor.copy(.5f)
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.horizontalScroll(scrollState)
        ) {
            Text(
                text = uiState.balance,
                color = onAccountColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            uiState.currency?.let {
                Text(
                    text = uiState.currency,
                    color = onAccountColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}


@Preview(device = Devices.PIXEL_7_PRO)
@Composable
private fun AccountComponentPreview() {
    PreviewContainer(appTheme = AppTheme.Light) {
        AccountComponent(
            uiState = AccountUiState(
                number = "1234567890",
                name = "Sample Account",
                balance = "1000.00",
                currency = "CZK"
            ),
            onClick = {}
        )
    }
}