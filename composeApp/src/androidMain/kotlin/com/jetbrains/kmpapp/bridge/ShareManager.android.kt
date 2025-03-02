package com.jetbrains.kmpapp.bridge

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

actual class ShareManager(private val context: Context) {
    actual fun shareText(message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            flags += Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra(Intent.EXTRA_TEXT, message)

        }
        val choicer = Intent.createChooser(intent, null)
        context.startActivity(choicer)
    }
}

@Composable
actual fun rememberShareManager(): ShareManager {
    val localContext = LocalContext.current
    return remember { ShareManager(localContext) }
}