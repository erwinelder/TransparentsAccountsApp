package com.transparentaccountsapp.requestHandling.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.transparentaccountsapp.core.domain.FilledWidthByScreenType
import com.transparentaccountsapp.core.presentation.component.button.SmallSecondaryButton
import com.transparentaccountsapp.core.presentation.theme.AppColors
import com.transparentaccountsapp.core.presentation.theme.CurrWindowType
import com.transparentaccountsapp.requestHandling.presentation.model.ResultState

@Composable
fun ResultErrorComponent(
    errorState: ResultState.ErrorState,
    onButtonClick: (() -> Unit)? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth(FilledWidthByScreenType().getByType(CurrWindowType))
    ) {
        Text(
            text = stringResource(errorState.titleRes),
            color = AppColors.onSurface,
            fontSize = 24.sp,
            fontWeight = FontWeight.W800,
            textAlign = TextAlign.Center
        )
        errorState.messageRes?.let {
            Text(
                text = stringResource(it),
                color = AppColors.onSurface,
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Center
            )
        }
        if (errorState.buttonTextRes != null && onButtonClick != null) {
            SmallSecondaryButton(
                text = stringResource(errorState.buttonTextRes),
                onClick = onButtonClick
            )
        }
    }
}