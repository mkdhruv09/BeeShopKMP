package com.jetbrains.kmpapp.bridge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication

actual class ShareManager {
    actual fun shareText(message: String) {
        val activityController = UIActivityViewController(listOf(message), null)
        UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
            activityController,
            animated = true,
            completion = null
        )
    }
}

@Composable
actual fun rememberShareManager(): ShareManager {
   return remember { ShareManager() }
}