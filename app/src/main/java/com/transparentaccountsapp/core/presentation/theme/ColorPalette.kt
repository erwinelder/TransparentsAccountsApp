package com.transparentaccountsapp.core.presentation.theme

import androidx.compose.ui.graphics.Color

sealed class ColorPalette(
    val primary: Color,
    val primaryText: Color,
    val primaryGradient: List<Color>,
    val primaryGradientPair: Pair<Color, Color> = Pair(primaryGradient[0], primaryGradient[1]),
    val primaryGlassGradient: List<Color>,
    val primaryGlassGradientPair: Pair<Color, Color> = Pair(
        primaryGlassGradient[0], primaryGlassGradient[1]
    ),
    val primaryGlassBorderGradient: List<Color>,
    val primarySemiTransparentGlassBorderGradient: List<Color>,
    val primarySemiTransparent: Color = primary.copy(alpha = .6f),
    val onPrimary: Color,

    val disabledGlassGradient: List<Color>,
    val disabledGlassGradientPair: Pair<Color, Color> = Pair(
        disabledGlassGradient[0], disabledGlassGradient[1]
    ),
    val disabledSemiTransparentGlassBorderGradient: List<Color>,
    val disabledSemiTransparentGradient: List<Color>,
    val disabledSemiTransparentGradientPair: Pair<Color, Color> = Pair(
        disabledSemiTransparentGradient[0], disabledSemiTransparentGradient[1]
    ),

    val glassGradient: List<Color>,
    val glassGradientPair: Pair<Color, Color> = Pair(glassGradient[0], glassGradient[1]),
    val glassBorderGradient: List<Color>,

    val glassGradientOnGlass: List<Color>,
    val glassGradientOnGlassBorder: Color,

    val background: Color,
    val surface: Color,
    val surfaceGradient: List<Color>,
    val onSurface: Color,

    val outline: Color,
    val outlineSemiTransparent: Color = outline.copy(alpha = .2f),

    val semiTransparentBorder: Color,

    val easyDifficultyColor: Color,
    val mediumDifficultyColor: Color,
    val hardDifficultyColor: Color,

    val success: Color,
    val successGradient: List<Color>,
    val successGradientPair: Pair<Color, Color> = Pair(successGradient[0], successGradient[1]),
    val error: Color,
    val errorGradient: List<Color>,
    val errorGradientPair: Pair<Color, Color> = Pair(errorGradient[0], errorGradient[1]),

    val successGlass: Color,
    val successGlassGradient: List<Color>,
    val successGlassGradientPair: Pair<Color, Color> = Pair(
        successGlassGradient[0], successGlassGradient[1]
    ),
    val errorGlass: Color,
    val errorGlassGradient: List<Color>,
    val errorGlassGradientPair: Pair<Color, Color> = Pair(
        errorGlassGradient[0], errorGlassGradient[1]
    ),

    val dangerousGlassGradient: List<Color>,
    val dangerousGlassGradientPair: Pair<Color, Color> = Pair(
        dangerousGlassGradient[0], dangerousGlassGradient[1]
    ),
) {
    data object Light : ColorPalette(
        primary = Color(124, 154, 207),
        primaryText = Color(101, 126, 168),
        primaryGradient = listOf(
            Color(119, 148, 199),
            Color(125, 158, 213)
        ),
        primaryGlassGradient = listOf(
            Color(89, 131, 201, 51),
            Color(97, 140, 213, 51)
        ),
        primaryGlassBorderGradient = listOf(
            Color(255, 255, 255, 77),
            Color(255, 255, 255, 64)
        ),
        primarySemiTransparentGlassBorderGradient = listOf(
            Color(191, 98, 146, 112),
            Color(163, 77, 130, 79)
        ),
        onPrimary = Color(245, 245, 245),

        background = Color.White,
        surface = Color(247, 247, 247),
        surfaceGradient = listOf(
            Color(232, 232, 232),
            Color(239, 239, 239)
        ),
        onSurface = Color(8, 8, 8),

        glassGradient = listOf(
            Color(252, 252, 252, 128),
            Color(240, 240, 240, 128)
        ),
        glassBorderGradient = listOf(
            Color(255, 255, 255, 140),
            Color(240, 240, 240, 140)
        ),

        glassGradientOnGlass = listOf(
            Color(247, 247, 247, 120),
            Color(255, 255, 255, 120)
        ),
        glassGradientOnGlassBorder = Color(255, 255, 255, 90),

        outline = Color(8, 8, 8, 128),

        semiTransparentBorder = Color(255, 255, 255, 50),

        disabledGlassGradient = listOf(
            Color(161, 161, 161, 204),
            Color(138, 138, 138, 204)
        ),
        disabledSemiTransparentGlassBorderGradient = listOf(
            Color(163, 163, 163, 204),
            Color(179, 179, 179, 204)
        ),
        disabledSemiTransparentGradient = listOf(
            Color(168, 168, 168, 64),
            Color(164, 164, 164, 64)
        ),

        easyDifficultyColor = Color(86, 165, 104),
        mediumDifficultyColor = Color(189, 164, 94),
        hardDifficultyColor = Color(188, 92, 92),

        success = Color(92, 180, 85),
        successGradient = listOf(
            Color(75, 148, 70),
            Color(92, 180, 85)
        ),
        error = Color(211, 92, 92),
        errorGradient = listOf(
            Color(171, 67, 67),
            Color(211, 92, 92)
        ),

        successGlass = Color(78, 168, 82),
        successGlassGradient = listOf(
            Color(130, 211, 110, 128),
            Color(121, 200, 101, 128)
        ),
        errorGlass = Color(199, 92, 92),
        errorGlassGradient = listOf(
            Color(229, 115, 115, 128),
            Color(219, 107, 107, 128)
        ),

        dangerousGlassGradient = listOf(
            Color(194, 95, 95),
            Color(212, 104, 104)
        ),

    )
    data object Dark : ColorPalette(
        primary = Color(77, 101, 143),
        primaryText = Color(90, 119, 168),
        primaryGradient = listOf(
            Color(76, 98, 138),
            Color(81, 106, 150)
        ),
        primaryGlassGradient = listOf(
            Color(124, 167, 241, 77),
            Color(131, 177, 255, 77)
        ),
        primaryGlassBorderGradient = listOf(
            Color(255, 255, 255, 31),
            Color(255, 255, 255, 15)
        ),
        primarySemiTransparentGlassBorderGradient = listOf(
            Color(212, 114, 168, 51),
            Color(168, 89, 126, 38)
        ),
        onPrimary = Color(245, 245, 245),

        background = Color.Black,
        surface = Color(33, 33, 33),
        surfaceGradient = listOf(
            Color(22, 22, 22),
            Color(29, 29, 29)
        ),
        onSurface = Color(237, 237, 237),

        glassGradient = listOf(
            Color(31, 31, 31, 128),
            Color(23, 23, 23, 128)
        ),
        glassBorderGradient = listOf(
            Color(255, 255, 255, 20),
            Color(102, 102, 102, 20)
        ),

        glassGradientOnGlass = listOf(
            Color(31, 31, 31, 120),
            Color(36, 36, 36, 120)
        ),
        glassGradientOnGlassBorder = Color(44, 44, 44, 128),

        outline = Color(247, 247, 247, 128),

        semiTransparentBorder = Color(0, 0, 0, 64),

        disabledGlassGradient = listOf(
            Color(89, 89, 89, 204),
            Color(77, 77, 77, 204)
        ),
        disabledSemiTransparentGlassBorderGradient = listOf(
            Color(56, 56, 56, 204),
            Color(46, 46, 46, 204)
        ),
        disabledSemiTransparentGradient = listOf(
            Color(106, 106, 106, 64),
            Color(110, 110, 110, 64)
        ),

        easyDifficultyColor = Color(78, 150, 94),
        mediumDifficultyColor = Color(162, 141, 82),
        hardDifficultyColor = Color(181, 82, 82),

        success = Color(82, 161, 76),
        successGradient = listOf(
            Color(72, 141, 66),
            Color(82, 161, 76)
        ),
        error = Color(169, 66, 66),
        errorGradient = listOf(
            Color(150, 52, 52),
            Color(169, 66, 66)
        ),

        successGlass = Color(71, 155, 75),
        successGlassGradient = listOf(
            Color(155, 233, 135, 128),
            Color(167, 244, 148, 128)
        ),
        errorGlass = Color(191, 86, 86),
        errorGlassGradient = listOf(
            Color(250, 123, 123, 128),
            Color(255, 129, 129, 128)
        ),

        dangerousGlassGradient = listOf(
            Color(158, 68, 68),
            Color(171, 73, 73)
        ),

    )
}