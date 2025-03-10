package com.jetbrains.kmpapp.screens.empty

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.no_data_available
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyScreenContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            stringResource(Res.string.no_data_available),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
