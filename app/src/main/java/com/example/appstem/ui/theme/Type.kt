package com.example.appstem.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appstem.R

val SanFranciscoFont= FontFamily(Font(R.font.sanfrancisco_regular))

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = SanFranciscoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp
    ),
    titleLarge = TextStyle(
        fontFamily = SanFranciscoFont,
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
        lineHeight = 28.sp
    ),
)



