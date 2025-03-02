package com.jetbrains.kmpapp.screens.product

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.jetbrains.kmpapp.bridge.ShareManager
import com.jetbrains.kmpapp.bridge.rememberShareManager
import com.jetbrains.kmpapp.components.AppButton
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppToolbar
import com.jetbrains.kmpapp.components.Avatar
import com.jetbrains.kmpapp.components.BORDER_WIDTH
import com.jetbrains.kmpapp.components.ChipViews
import com.jetbrains.kmpapp.components.GlideImage
import com.jetbrains.kmpapp.components.RatingBar
import com.jetbrains.kmpapp.components.SCREEN_PADDING
import com.jetbrains.kmpapp.components.SmallDivider
import com.jetbrains.kmpapp.components.roundedBordered
import com.jetbrains.kmpapp.components.roundedUnBordered
import com.jetbrains.kmpapp.data.model.Product
import com.jetbrains.kmpapp.data.model.ProductMedia
import com.jetbrains.kmpapp.theme.BeeShopTheme
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.product_detail
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.absoluteValue

@Composable
fun ProductDetailScreen(
    productId: String = "",
    onCartRedirect: () -> Unit = {},
    navigateBack: () -> Unit = {},
) {
    val screenModel = koinViewModel<ProductDetailScreenViewModel>()
    val detail by screenModel.detailSharedFlow.collectAsState()

    BeeShopTheme {
        AppScreenScaffold(
            modifier = Modifier, containerColor = Color.White, topBar = {
                AppToolbar(
                    title = stringResource(Res.string.product_detail),
                    showBack = true,
                    onBackPress = navigateBack,
                    endWidget = {
                        ShareProduct()
                    }
                )
            }) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                if (detail.showLoading) {
                    ProductDetailShimmer()
                } else {
                    ProductDetail(
                        product = detail.product!!,
                        onCartRedirect = onCartRedirect
                    )
                }
            }
        }
    }
    LaunchedEffect(key1 = Unit) {
        screenModel.getDetail(id = productId)
    }
}

@Composable
fun ShareProduct() {
    val shareManager = rememberShareManager()
    Icon(imageVector = Icons.Filled.Share,
        contentDescription = "share",
        tint = Color.Black,
        modifier = Modifier.padding(8.dp).clickable {
            shareManager.shareText("Hello World")
        })
}

@Composable
private fun ProductDetail(
    product: Product,
    onCartRedirect: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            val coroutineScope = rememberCoroutineScope()
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Spacer(modifier = Modifier.height(16.dp))

                val pagerState =
                    rememberPagerState(pageCount = { product.media.size }, initialPage = 2)

                ProductImageSlider(pagerState = pagerState,
                    list = product.media,
                    onTap = {
                        //navigator.navigate(ProductGalleryScreenDestination)
                    })
                Spacer(modifier = Modifier.height(10.dp))
                ProductImagesStrip(
                    list = product.media,
                    currentSelected = pagerState.currentPage,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(it)
                        }
                    })

                Spacer(modifier = Modifier.height(15.dp))

                ProductInformation(modifier = Modifier,
                    product = product,
                    onReviewClick = { offset ->
                        coroutineScope.launch {
                            scrollState.animateScrollTo(offset.y.toInt())
                        }
                    })
            }
        }
        AppButton(
            icon = Icons.Filled.ShoppingCart,
            text = "Add to Cart",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            onClick = {
                onCartRedirect()
                //navigator.navigate(CartScreenDestination)
            }
        )
    }
}

@Composable
private fun ProductImagesStrip(
    list: List<ProductMedia>,
    currentSelected: Int = 2,
    onClick: (Int) -> Unit = {}
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(SCREEN_PADDING)
    ) {
        itemsIndexed(list) { i, item ->
            val isSelected = i == currentSelected
            GlideImage(
                model = item.src,
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
                    .run { if (isSelected) roundedBordered() else roundedUnBordered() }
                    .clickable { onClick(i) }
            )
        }
    }
}

@Composable
private fun ProductInformation(
    product: Product,
    onReviewClick: (Offset) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var reviewWidgetPosition by remember {
        mutableStateOf(Offset.Zero)
    }
    Column(modifier = modifier) {
        //Title and Price Section
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            Text(
                text = product.title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(SCREEN_PADDING))
            ProductPriceWidget()
            Spacer(modifier = Modifier.height(SCREEN_PADDING))

            ProductRating(onClick = {
                onReviewClick.invoke(reviewWidgetPosition)
            })
        }
        Spacer(modifier = Modifier.height(5.dp))

        SmallDivider(modifier.padding(vertical = 5.dp), isLight = true)

        //Variant Section
        Column(modifier = Modifier.padding(horizontal = SCREEN_PADDING)) {
            Spacer(modifier = Modifier.height(SCREEN_PADDING))
            ProductColorVariant()
            Spacer(modifier = Modifier.height(SCREEN_PADDING))
            ProductSizeVariant()
            Spacer(modifier = Modifier.height(SCREEN_PADDING))
        }
        SmallDivider(modifier.padding(vertical = 5.dp), isLight = true)

        //Description Section
        Column(modifier = Modifier.padding(SCREEN_PADDING)) {
            ProductSeparatorHeadline(text = "Description")
            Spacer(modifier = Modifier.height(SCREEN_PADDING))
            Text(
                text = product.description,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        //Review Rating Section
        ProductRatingSection(modifier = Modifier.onGloballyPositioned {
            reviewWidgetPosition = it.positionInRoot()
        })
        ProductReviewCommentSection(
            modifier = modifier.padding(
                SCREEN_PADDING
            )
        )


        //Dummy Space
        Spacer(modifier = Modifier.height(100.dp))
    }
}


@Composable
private fun ProductRating(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onClick() }) {
        RatingBar(
            rating = 3.0,
            modifier = Modifier.height(15.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "(500 reviews)",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun ProductColorVariant(modifier: Modifier = Modifier) {
    val colors = mutableListOf(Color.Red, Color.Blue, Color.Magenta, Color.Green)
    Column(modifier = modifier) {
        ProductSeparatorHeadline(text = "Choose Color")
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            itemsIndexed(colors) { index, item ->
                val isSelected = index == 2
                Box(modifier = Modifier.height(IntrinsicSize.Min)) {
                    Spacer(
                        modifier = Modifier
                            .size(35.dp)
                            .background(color = item, shape = CircleShape)
                            .run {
                                if (isSelected) {
                                    border(
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        shape = RoundedCornerShape(100),
                                        width = BORDER_WIDTH
                                    )
                                } else this
                            }
                    )
                    if (isSelected) {
                        Icon(
                            Icons.Filled.Done,
                            contentDescription = "done",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(2.dp)
                                .align(Alignment.Center),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductSizeVariant(modifier: Modifier = Modifier) {
    val sizes = mutableListOf("S", "M", "L", "XL", "XXL", "XXXL")
    Column {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            ProductSeparatorHeadline(text = "Choose Size")
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "info",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(5.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        ChipViews(items = sizes)
    }
}

@Composable
private fun ProductPriceWidget(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "₹120",
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge.copy(textDecoration = TextDecoration.LineThrough)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier.padding(horizontal = 5.dp),
            text = "₹99",
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "20% Off", color = Color.Red, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .border(
                    shape = RoundedCornerShape(100),
                    color = MaterialTheme.colorScheme.onPrimary,
                    width = BORDER_WIDTH
                )
                .padding(horizontal = 16.dp, vertical = 4.dp),
            text = "Saved ₹21",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
private fun ProductImageSlider(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    list: List<ProductMedia>,
    onTap: () -> Unit = {}
) {

    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 60.dp),
        pageSpacing = 8.dp
    ) {
        val item = list[it]
        Box(
            modifier = Modifier
                .aspectRatio(1.0f)
                .clip(RoundedCornerShape(5))
                .carouselTransition(it, pagerState = pagerState)
                .clickable {
                    onTap()
                }
        ) {
            GlideImage(
                model = item.src,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.primary),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
@Preview
fun ProductRatingSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ProductSeparatorHeadline(text = "Rating & Reviews", modifier = Modifier.padding(12.dp))
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.35f))
                .border(width = BORDER_WIDTH, color = MaterialTheme.colorScheme.onPrimary)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.45f)
                    .fillMaxHeight()
                    .padding(SCREEN_PADDING),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "4.5",
                    fontSize = 36.sp,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))
                RatingBar(
                    rating = 3.0,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(100)
                        )
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "40 Customers Rating",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.width(12.dp))
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(BORDER_WIDTH)
                    .background(MaterialTheme.colorScheme.onPrimary)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.55f)
                    .padding(SCREEN_PADDING), verticalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 1..5) {
                    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "$i", style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onPrimary
                        )

                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "star",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        //Progress bar background
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(100)
                                )
                                .border(
                                    width = BORDER_WIDTH,
                                    shape = RoundedCornerShape(100),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                        )
                        {
                            //Progress bar value
                            Spacer(
                                modifier = Modifier
                                    .width(100.dp)
                                    .fillMaxHeight()
                                    .background(
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        shape = RoundedCornerShape(100)
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductReviewCommentSection(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp), modifier = modifier
    ) {
        for (i in 1..5) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Avatar(modifier = Modifier.size(40.dp), name = "Krupal Mehta")
                Spacer(modifier = Modifier.width(SCREEN_PADDING))
                Column(modifier = Modifier) {
                    Text(
                        text = "Krupal Mehta", color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleSmall
                    )
                    RatingBar(
                        modifier = Modifier.height(12.dp),
                        rating = 3.5
                    )
                    Text(
                        text = "It's very good quality. i really liked. I'm using daily",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }

}

@Composable
fun ProductSeparatorHeadline(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Composable
fun Modifier.carouselTransition(page: Int, pagerState: PagerState) = composed {
    graphicsLayer {
        val pageOffset =
            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

        val transformation =
            lerp(
                start = 1.0f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f)
            )
        scaleY = transformation
        shape = RoundedCornerShape(15)
    }
}
