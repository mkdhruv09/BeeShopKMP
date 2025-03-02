package com.jetbrains.kmpapp.bridge

import androidx.compose.runtime.Composable

expect class ShareManager {
    fun shareText(message: String)
}

@Composable
expect fun rememberShareManager(): ShareManager



