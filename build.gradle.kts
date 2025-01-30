plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinxSerialization) apply false
    id("org.jetbrains.compose-hot-reload") version "1.0.0-dev.34.1" // <- add this additionally
}
