package com.transparentaccountsapp.core.presentation.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.transparentaccountsapp.R
import com.transparentaccountsapp.core.domain.FilledWidthByScreenType
import com.transparentaccountsapp.core.presentation.component.container.GlassSurface
import com.transparentaccountsapp.core.presentation.modifier.bounceClickEffect
import com.transparentaccountsapp.core.presentation.theme.AppColors
import com.transparentaccountsapp.core.presentation.theme.CurrWindowType

@Composable
fun GlassSurfaceNavigationButton(
    text: String,
    onClick: () -> Unit
) {
    GlassSurface(
        filledWidths = null,
        cornerSize = 24.dp,
        modifier = Modifier
            .bounceClickEffect(.98f, onClick = onClick)
            .fillMaxWidth(FilledWidthByScreenType(.96f, .75f, .75f).getByType(CurrWindowType))
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.short_arrow_left_icon),
                contentDescription = "left arrow icon",
                tint = AppColors.onSurface,
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = text,
                color = AppColors.onSurface,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.weight(1f, fill = true)
            )
        }
    }
}