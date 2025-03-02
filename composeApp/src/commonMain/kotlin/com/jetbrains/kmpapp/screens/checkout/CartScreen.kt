package com.jetbrains.kmpapp.screens.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.components.AppButton
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppToolbar
import com.jetbrains.kmpapp.components.BORDER_WIDTH
import com.jetbrains.kmpapp.components.GlideImage
import com.jetbrains.kmpapp.components.SCREEN_PADDING
import com.jetbrains.kmpapp.components.SmallDivider
import com.jetbrains.kmpapp.components.roundedBordered
import com.jetbrains.kmpapp.data.model.Product
import com.jetbrains.kmpapp.theme.BeeShopTheme
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CartScreen(onBack: () -> Unit = {},
               onNavigatePayment:()->Unit={}) {
    BeeShopTheme {
        AppScreenScaffold(containerColor = Color.White, topBar = {
            Column {
                AppToolbar(
                    title = "Cart",
                    showBack = true,
                    onBackPress = onBack,
                )
                val coroutineScope = rememberCoroutineScope()
                CartAddress(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(SCREEN_PADDING),
                    onChange = {
                        coroutineScope.launch {
                            //sheetState.show()
                        }
                    }
                )
                SmallDivider()
            }
        }) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding())
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(SCREEN_PADDING),
                    contentPadding = PaddingValues(
                        SCREEN_PADDING
                    )
                ) {
                    items(3) {
                        CartProduct()
                    }
                    item {
                        CartPriceSummary()
                    }
                    item {  //Dummy Space
                        Spacer(modifier = Modifier.height(100.dp))
                    }
                }
                CartPlaceOrder(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onPlaceOrder = {
                        onNavigatePayment()
                    })
            }
        }

    }
}

@Composable
fun CartPriceSummary(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .roundedBordered()
            .padding(SCREEN_PADDING), verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        CartSummaryItem(title = "Grand Total", price = "$100")
        CartSummaryItem(title = "Shipping Charge", price = "$10")
        CartSummaryItem(title = "Coupon Discount", price = "-$10")
        CartSummaryItem(title = "Total Amount", price = "$100")
    }
}

@Composable
fun CartSummaryItem(title: String, price: String) {
    Row {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = price,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun CartAddress(modifier: Modifier = Modifier, onChange: () -> Unit = {}) {
    Column(modifier = modifier.background(color = Color.White)) {

        Text(
            text = "Deliver To",
            modifier = Modifier

                .padding(end = 5.dp),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Krupal Mehta",
            modifier = Modifier, style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "D-12/138 Nandanvan appt, Nava Vadaj, Ahmedabad",
            modifier = Modifier, style = MaterialTheme.typography.bodyMedium
        )

        AppButton(
            text = "Change", modifier = Modifier
                .padding(horizontal = 10.dp)
                .height(30.dp), onClick = onChange
        )
    }
}

@Composable
fun CartPlaceOrder(modifier: Modifier = Modifier, onPlaceOrder: () -> Unit = {}) {
    Column(modifier = modifier) {
        SmallDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(SCREEN_PADDING), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Total Amount", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "$900", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.width(5.dp))
            androidx.compose.material3.Icon(
                imageVector = Icons.Filled.Place,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.weight(1f))
            AppButton(text = "Place Order", onClick = onPlaceOrder, icon = Icons.Outlined.Refresh)
        }
    }
}

@Composable
@Preview
fun CartProduct() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .roundedBordered()
            .padding(SCREEN_PADDING)
    )
    {
        Column(modifier = Modifier.fillMaxWidth()) {
            GlideImage(
                model = Product.SAMPLE_IMAGE,
                contentDescription = "image",
                modifier = Modifier
                    .size(120.dp)
                    .roundedBordered()
            )

            Text(
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium,
                text = Product.SAMPLE_TITLE,
                maxLines = 2,
                modifier = Modifier,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineSmall,
                text = "₹999",
                maxLines = 2,
                modifier = Modifier
                    .padding(top = 10.dp, start = SCREEN_PADDING)
            )
        }

        CartCounter(modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun CartCounter(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .border(
                width = BORDER_WIDTH,
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(100)
            )
    ) {
        Text(
            text = "-",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .size(30.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(
                        topStartPercent = 100,
                        bottomStartPercent = 100
                    )
                )
                .border(
                    color = MaterialTheme.colorScheme.onPrimary,
                    width = BORDER_WIDTH,
                    shape = RoundedCornerShape(
                        topStartPercent = 100,
                        bottomStartPercent = 100
                    )
                )
                .padding(horizontal = 5.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.White)
                .padding(horizontal = 5.dp)
        ) {
            Text(
                style = MaterialTheme.typography.bodyMedium,
                text = "10",
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = "+",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .size(30.dp)
                .fillMaxHeight()
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(
                        topEndPercent = 100,
                        bottomEndPercent = 100
                    )
                )
                .border(
                    color = MaterialTheme.colorScheme.onPrimary,
                    width = BORDER_WIDTH,
                    shape = RoundedCornerShape(
                        topEndPercent = 100,
                        bottomEndPercent = 100
                    )
                )
                .padding(5.dp)
        )
    }
}