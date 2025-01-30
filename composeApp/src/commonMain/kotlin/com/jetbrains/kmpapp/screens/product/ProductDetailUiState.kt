package com.jetbrains.kmpapp.screens.product

import com.jetbrains.kmpapp.data.model.Product

data class ProductDetailUiState(
    val showLoading: Boolean = false,
    val product: Product? = null
)