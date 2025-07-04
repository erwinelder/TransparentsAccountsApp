package com.transparentaccountsapp.core.presentation.component.container

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.transparentaccountsapp.core.domain.AppTheme
import com.transparentaccountsapp.core.domain.FilledWidthByScreenType
import com.transparentaccountsapp.core.presentation.preview.PreviewContainer
import com.transparentaccountsapp.core.presentation.theme.AppColors
import com.transparentaccountsapp.core.presentation.theme.CurrWindowType

@Composable
fun GlassSurface(
    modifier: Modifier = Modifier,
    filledWidths: FilledWidthByScreenType? = FilledWidthByScreenType(),
    gradientColor: List<Color> = AppColors.glassGradient,
    cornerSize: Dp = 38.dp,
    borderSize: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(),
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        contentAlignment = contentAlignment,
        modifier = modifier
            .run {
                filledWidths?.let { fillMaxWidth(it.getByType(CurrWindowType)) } ?: this
            }
            .clip(RoundedCornerShape(cornerSize))
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColor,
                    start = Offset(1100f, 0f),
                    end = Offset(0f, 1200f)
                )
            )
            .border(
                width = borderSize,
                brush = Brush.linearGradient(
                    colors = AppColors.glassBorderGradient,
                    start = Offset(100f, 0f),
                    end = Offset(0f, 120f)
                ),
                shape = RoundedCornerShape(cornerSize)
            )
            .padding(borderSize)
            .padding(contentPadding)
    ) {
        content()
    }
}

@Preview(device = Devices.PIXEL_7_PRO)
@Composable
private fun GlassSurfacePreview() {
    PreviewContainer(appTheme = AppTheme.Light) {
        GlassSurface {
            Box(modifier = Modifier.size(300.dp))
        }
    }
}