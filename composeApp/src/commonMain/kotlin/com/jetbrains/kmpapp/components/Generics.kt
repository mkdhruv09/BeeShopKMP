package com.jetbrains.kmpapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TinySpace(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .size(4.dp)
    )
}

@Composable
fun SmallSpace(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .size(8.dp)
    )
}

@Composable
fun MediumSpace(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .size(12.dp)
    )
}

@Composable
fun LargeSpace(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .size(16.dp)
    )
}