package com.transparentaccountsapp.core.presentation.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection


operator fun PaddingValues.plus(paddingValues: PaddingValues): PaddingValues {
    return PaddingValues(
        start = this.start + paddingValues.start,
        top = this.top + paddingValues.top,
        end = this.end + paddingValues.end,
        bottom = this.bottom + paddingValues.bottom
    )
}

val PaddingValues.start: Dp
    get() = calculateStartPadding(LayoutDirection.Ltr)

val PaddingValues.end: Dp
    get() = calculateEndPadding(LayoutDirection.Ltr)

val PaddingValues.top: Dp
    get() = calculateTopPadding()

val PaddingValues.bottom: Dp
    get() = calculateBottomPadding()
