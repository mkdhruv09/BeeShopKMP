package com.jetbrains.kmpapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.BORDER_WIDTH
import com.jetbrains.kmpapp.components.GlideImage
import com.jetbrains.kmpapp.components.ListHeader
import com.jetbrains.kmpapp.components.SearchView
import com.jetbrains.kmpapp.components.roundedBordered
import com.jetbrains.kmpapp.data.model.Product
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bee_banner
import org.jetbrains.compose.resources.painterResource

@Composable
fun DashboardTabScreen(
    onProductDetail: () -> Unit = {},
    onReelsClick: () -> Unit = {}
) {
    AppScreenScaffold(containerColor = Color.White) { paddingValues ->
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SearchView(
                text = "Search here",
                modifier = Modifier.padding(12.dp)
            )
            HomeAdBanner()

            Spacer(modifier = Modifier.height(12.dp))

            HomeCategoryList(onCategoryClick = {

            })

            Spacer(modifier = Modifier.height(12.dp))
            HomeProductHorizontal(title = "Today's Pick", onProductClick = {
            })

            Spacer(modifier = Modifier.height(12.dp))
            HomeReels(onClick = {
                onReelsClick()
            })

            Spacer(modifier = Modifier.height(12.dp))
            UnderDeals()

            Spacer(modifier = Modifier.height(12.dp))
            HomeProductVertical(onProductClick = {
                onProductDetail()
            })
        }
    }
}

//@ShowkaseComposable("HomeCategoryList", group = "HomeWidgets")
@Composable
fun HomeCategoryList(onCategoryClick: () -> Unit = {}) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp)
    ) {
        items(10) {
            HomeCategoryWidget(onCategoryClick = onCategoryClick)
        }
    }
}

@Composable
fun HomeCategoryWidget(onCategoryClick: () -> Unit = {}) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .border(
                    width = BORDER_WIDTH,
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = CircleShape
                )
                .padding(12.dp)
                .clickable { onCategoryClick() }
        ) {
            Image(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "",
                modifier = Modifier
                    .size(45.dp)
                    .padding(2.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Gadgets", color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

//@ShowkaseComposable("HomeReels", group = "HomeWidgets")
//@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeReels(onClick: () -> Unit = {}) {
    Column(modifier = Modifier) {
        ListHeader(title = "Reels")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        ) {
            items(4) {
                Box(
                    modifier = Modifier
                        .roundedBordered()
                        .clickable { onClick() }
                ) {
                    GlideImage(
                        contentScale = ContentScale.Crop,
                        model = "https://cdn.shopify.com//s//files//1//0782//3284//6646//files//03_d1f478ef-8d92-447d-8d35-3a146735bd3b.jpg?v=1707553784",
                        contentDescription = "",
                        modifier = Modifier
                            .height(200.dp)
                            .aspectRatio(4.0f / 5.0f)
                    )

                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "play",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(5.dp)
                            .background(
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
                                shape = RoundedCornerShape(50)
                            )
                            .padding(5.dp)
                            .size(30.dp)
                    )
                }
            }
        }
    }
}


//@ShowkaseComposable("HomeProductsHorizontal", group = "HomeWidgets")
@Composable
fun HomeProductHorizontal(title: String = "", onProductClick: () -> Unit = {}) {
    Column(modifier = Modifier) {
        ListHeader(title)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(10) {
                HomeProduct(
                    modifier = Modifier.width(150.dp),
                    url = Product.SAMPLE_IMAGE,
                    onProductClick = onProductClick
                )
            }
        }
    }
}

//@ShowkaseComposable("HomeProductsVertical", group = "HomeWidgets")
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeProductVertical(onProductClick: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxWidth()) {
        ListHeader("Popular Products")
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement=Arrangement.spacedBy(10.dp),
            maxItemsInEachRow = 8,
            overflow = FlowRowOverflow.Visible
        ) {
            repeat(10) {
                HomeProduct(
                    url = Product.SAMPLE_IMAGE,
                    modifier = Modifier
                        .height(100.dp)
                        .width(200.dp),
                    onProductClick = onProductClick
                )
            }
        }
    }
}


//@ShowkaseComposable("HomeProduct", group = "HomeWidgets")
@Composable
fun HomeProduct(url: String = "", modifier: Modifier = Modifier, onProductClick: () -> Unit = {}) {
    Column(
        modifier = modifier
            .width(intrinsicSize = IntrinsicSize.Min)
            .clickable { onProductClick() })
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .border(
                    width = BORDER_WIDTH,
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(10)
                )
                .clip(RoundedCornerShape(10))
        ) {
            GlideImage(
                model = url,
                contentDescription = "image",
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Round Plastic Dinner Plate",
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "₹120",
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium.copy(textDecoration = TextDecoration.LineThrough)
            )
            Text(
                modifier = Modifier.padding(horizontal = 5.dp),
                text = "₹99",
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(text = "20% Off", color = Color.Red, style = MaterialTheme.typography.bodyMedium)
        }
    }
}


//@ShowkaseComposable("HomeAdBanner", group = "HomeWidgets")
@Composable
fun HomeAdBanner() {
    Image(
        painter = painterResource(Res.drawable.bee_banner),
        contentDescription = "",
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(10))
            .border(
                width = BORDER_WIDTH,
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(10)
            ), contentScale = ContentScale.Crop
    )
}


//@ShowkaseComposable("HomeUnderDeals", group = "HomeWidgets")
@Composable
fun UnderDeals() {
    val list = mutableListOf(99, 199, 299, 399, 499)
    Column(modifier = Modifier) {
        ListHeader(title = "Rocket Deals", showViewAll = false)
        LazyRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(list)
            {
                Column(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        )
                        .border(
                            width = BORDER_WIDTH,
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = CircleShape
                        )
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Under",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        modifier = Modifier,
                        text = "₹$it",
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        fontSize = 26.sp,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}