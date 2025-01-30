/*
package com.beeshop.app.ui.module.product

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
import com.beeshop.app.data.model.Product
import com.beeshop.app.ui.components.AppScreenScaffold
import com.beeshop.app.ui.components.SearchView
import com.beeshop.app.ui.module.destinations.ProductDetailScreenDestination
import com.beeshop.app.ui.module.dashboard.HomeProduct
import com.beeshop.app.ui.module.home.TabNavGraph
import com.beeshop.app.utils.compose.LocalRootNavigation
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
@TabNavGraph
fun ProductsTabScreen(tabNavigator: DestinationsNavigator) {
    val localRootNavigator = LocalRootNavigation.current
    AppScreenScaffold(containerColor = Color.White, navigator = tabNavigator) {
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
                        localRootNavigator?.navigate(ProductDetailScreenDestination(productId = "1"))
                    }
                }
            }
        }
    }
}*/
