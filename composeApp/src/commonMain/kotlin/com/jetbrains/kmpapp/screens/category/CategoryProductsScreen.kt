package com.jetbrains.kmpapp.screens.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppToolbar
import com.jetbrains.kmpapp.components.GlideImage
import com.jetbrains.kmpapp.data.model.Product
import com.jetbrains.kmpapp.screens.home.HomeProduct
import com.jetbrains.kmpapp.theme.BeeShopTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun CategoryProductsScreen(
    categoryId: String = "",
    onProductDetail: () -> Unit = {}
) {
    BeeShopTheme {
        AppScreenScaffold(containerColor = Color.White) { paddingValues ->
            Column {
                AppToolbar(title = "Category Detail", showBack = true)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(12.dp)
                ) {
                    items(10) {
                        HomeProduct(
                            modifier = Modifier,
                            url = Product.SAMPLE_IMAGE,
                            onProductClick = {
                                onProductDetail()
                            })
                    }
                }
            }
        }
    }
}


@Composable
fun ProductMiniCard(onClick: () -> Unit = {}) {
    Column {
        GlideImage(
            model = "https://cdn.shopify.com/s/files/1/0782/3284/6646/files/6bd19479-2f39-4904-af0b-0862b5ae4409.jpg",
            contentDescription = "image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10))
                .clickable { onClick() }
        )

        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(50)
                )
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(50),
                    color = MaterialTheme.colorScheme.onPrimary
                )
        )
        {
            Text(
                text = "Add to Cart",
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .align(
                        Alignment.Center
                    )
                    .padding(8.dp),
                fontSize = 18.sp
            )
        }
    }

}