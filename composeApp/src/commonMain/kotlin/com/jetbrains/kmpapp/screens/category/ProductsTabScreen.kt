package com.jetbrains.kmpapp.screens.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.SearchView
import com.jetbrains.kmpapp.data.model.Product
import com.jetbrains.kmpapp.screens.home.HomeProduct

@Composable
fun ProductsTabScreen() {
    AppScreenScaffold(containerColor = Color.White) {
        Column(modifier = Modifier) {
            SearchView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), text = "Search Products"
            )
            LazyVerticalGrid(
                contentPadding = PaddingValues(12.dp),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(100) {
                    HomeProduct(url = Product.SAMPLE_IMAGE, modifier = Modifier.fillMaxWidth()) {

                    }
                }
            }
        }
    }
}