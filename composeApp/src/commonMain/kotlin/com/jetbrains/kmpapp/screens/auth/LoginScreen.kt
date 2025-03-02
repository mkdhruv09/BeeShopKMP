package com.jetbrains.kmpapp.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.components.AppButton
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppTextField
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.app_logo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun LoginScreen(onValidateLogin: () -> Unit = {}) {
    AppScreenScaffold(containerColor = Color.Yellow) { paddingValues ->
        var emailText by remember {
            mutableStateOf("")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(50.dp))
            Icon(
                painter = painterResource(Res.drawable.app_logo),
                contentDescription = "beeshop",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = "BeeShopee",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.weight(0.3f))
            Text(
                text = "Login with Mobiles",
                style = MaterialTheme.typography.headlineMedium,
            )
            Spacer(modifier = Modifier.height(12.dp))
            AppTextField(
                value = emailText,
                placeHolder = "Mobile",
                onValueChange = {
                    emailText = it
                }, modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "By continuing i'm agree to Beeshop's",
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Terms & Conditions",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.clickable {
                    //launchTermsAndCondition()
                }
            )
            Text(
                text = "Privacy Policy",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.clickable {
                    //launchPrivacyPolicy()
                }
            )
            AppButton(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                text = "Login"
            ) {
                onValidateLogin()
            }
        }
    }
}