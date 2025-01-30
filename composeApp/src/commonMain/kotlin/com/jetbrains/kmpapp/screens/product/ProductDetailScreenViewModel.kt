package com.jetbrains.kmpapp.screens.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetbrains.kmpapp.data.MuseumRepository
import com.jetbrains.kmpapp.data.model.Product
import com.jetbrains.kmpapp.data.model.ProductResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json


class ProductDetailScreenViewModel : ViewModel() {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(json = Json {
                prettyPrint = true
                ignoreUnknownKeys = true
            }, contentType = ContentType.Application.Any)
        }
    }

    val detailSharedFlow = MutableStateFlow(ProductDetailUiState(showLoading = true))

    fun getDetail(id:String) {
        if (detailSharedFlow.value.product == null) {
            viewModelScope.launch(Dispatchers.IO) {
                detailSharedFlow.update { state -> state.copy(showLoading = true) }
                val response = getProductDetail()
                detailSharedFlow.update { state ->
                    state.copy(
                        showLoading = false,
                        product = response
                    )
                }
            }
        }
    }

    private suspend fun getProductDetail(): Product {
        return client.get("https://mocki.io/v1/4893570b-89e4-4da5-9fd5-302f29c54e6c")
            .body<ProductResponse>().product
    }
}