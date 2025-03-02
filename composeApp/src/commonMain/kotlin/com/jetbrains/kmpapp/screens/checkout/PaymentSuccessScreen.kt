package com.jetbrains.kmpapp.screens.checkout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.components.AppButton
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppToolbar
import com.jetbrains.kmpapp.components.SCREEN_PADDING
import com.jetbrains.kmpapp.theme.BeeShopTheme

@Composable
fun PaymentSuccessScreen(onHomeRedirect: () -> Unit = {}) {
    BeeShopTheme {
        AppScreenScaffold(topBar = {
            AppToolbar(title = "Payment Success")
        }) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(SCREEN_PADDING),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Loader(
                        modifier = Modifier
                            .size(200.dp)
                    )
                    Text(
                        text = "You order successfully placed. You'll receive your shortly.",
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                }

                AppButton(icon = Icons.Outlined.Home,
                    text = "Go to Home",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(SCREEN_PADDING),
                    onClick = {
                        onHomeRedirect()
                    })
            }
        }
    }
}

@Composable
fun Loader(modifier: Modifier) {
    /*val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.payment_success))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = { progress },
    )*/
}