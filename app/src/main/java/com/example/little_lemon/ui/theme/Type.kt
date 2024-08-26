package com.example.little_lemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon2.R


val  karla = FontFamily(Font(R.font.karla_regular))
val markazi = FontFamily(Font(R.font.markazi_text_regular))

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    h1 = TextStyle(
        fontFamily = markazi,
        fontWeight = FontWeight.SemiBold,
        fontSize = 44.sp
    ),

    h3 = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = PrimaryGreen
    ),
    body2 = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)