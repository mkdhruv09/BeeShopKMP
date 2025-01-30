package com.jetbrains.kmpapp.screens.auth

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import com.jetbrains.kmpapp.components.AppButton
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppToolbar
import com.jetbrains.kmpapp.components.BORDER_WIDTH
import com.jetbrains.kmpapp.components.SCREEN_PADDING
import com.jetbrains.kmpapp.theme.BeeShopTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun OtpVerificationScreen(
) {
    BeeShopTheme {
        val context = LocalPlatformContext.current
        var otpText by remember {
            mutableStateOf("123456")
        }
        AppScreenScaffold(
            containerColor = MaterialTheme.colorScheme.primary,
            topBar = {
                AppToolbar(title = "", showBack = true, showDivider = false)
            }
        ) { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Icon(
                    Icons.Filled.Check,
                    contentDescription = "otp banner",
                    modifier = Modifier.size(160.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "Verify Your OTP",
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(100.dp))
                Text(
                    textAlign = TextAlign.Center,
                    text = "We've sent an OTP on +91 9662143557",
                    style = MaterialTheme.typography.headlineMedium,
                )
                Spacer(modifier = Modifier.height(20.dp))
                /*OtpView(
                    onOtpTextChange = { otpText = it },
                    otpCount = 6,
                    type = OTP_VIEW_TYPE_BORDER,
                    containerSize = 50.dp,
                    otpText = otpText
                )*/
                Spacer(modifier = Modifier.height(10.dp))
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Haven't received OTP on your phone?",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Resend OTP",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .border(
                            shape = RoundedCornerShape(100),
                            width = BORDER_WIDTH,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .clickable {
                            //context.showToast("Otp Sent Successfully")
                        },
                )
                Spacer(modifier = Modifier.weight(1f))
                AppButton(
                    text = "Continue",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(SCREEN_PADDING),
                    onClick = {
                    })
            }
        }
    }
}