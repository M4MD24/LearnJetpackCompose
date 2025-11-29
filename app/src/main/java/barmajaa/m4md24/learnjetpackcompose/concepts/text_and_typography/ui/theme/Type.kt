package barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val SimpleText = Typography(
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        letterSpacing = 0.2.sp,
        shadow = Shadow(
            color = Color.Black,
            blurRadius = 20f
        )
    )
)

val Colorful = Typography(
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        letterSpacing = 0.2.sp,
        shadow = Shadow(
            color = Color.Red,
            blurRadius = 25f
        )
    )
)