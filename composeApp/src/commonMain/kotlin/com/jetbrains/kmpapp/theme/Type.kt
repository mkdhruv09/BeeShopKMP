package com.jetbrains.kmpapp.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.mont_bold
import kmp_app_template.composeapp.generated.resources.mont_medium
import kmp_app_template.composeapp.generated.resources.mont_regular
import kmp_app_template.composeapp.generated.resources.mont_semibold
import org.jetbrains.compose.resources.Font


val monteseratFamily: FontFamily
    @Composable
    get() {
        return FontFamily(
            Font(resource = Res.font.mont_regular),
            Font(resource = Res.font.mont_medium, FontWeight.Normal, FontStyle.Normal),
            Font(resource = Res.font.mont_medium, FontWeight.SemiBold, FontStyle.Normal),
            Font(resource = Res.font.mont_semibold, FontWeight.Bold, FontStyle.Normal),
            Font(resource = Res.font.mont_bold, FontWeight.ExtraBold, FontStyle.Normal)
        )
    }

// Set of Material typography styles to start with
val Typography1: Typography
    @Composable
    get() {
        return Typography(
            //Body Types
            bodyLarge = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp
            ), bodyMedium = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp
            ), bodySmall = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 12.sp,
                letterSpacing = 0.sp
            ),

            //Title Types
            titleLarge = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.sp
            ),
            titleMedium = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp
            ),
            titleSmall = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp
            ),

            //Headline Types
            headlineLarge = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.sp
            ),
            headlineMedium = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp
            ),
            headlineSmall = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp
            ),


            //Label Types
            labelLarge = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp
            ), labelMedium = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp
            ), labelSmall = TextStyle(
                color = PurpleGrey80,
                fontFamily = monteseratFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 12.sp,
                letterSpacing = 0.sp
            )
        )
    }