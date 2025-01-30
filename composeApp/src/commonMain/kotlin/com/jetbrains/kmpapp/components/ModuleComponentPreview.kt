/*
package com.beeshop.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.beeshop.app.ui.module.checkout.CartProduct
import com.jetbrains.kmpapp.screens.home.HomeCategoryList
import com.jetbrains.kmpapp.screens.home.HomeCategoryWidget
import com.jetbrains.kmpapp.screens.home.HomeProduct
import com.jetbrains.kmpapp.screens.home.SettingGroup
import com.jetbrains.kmpapp.screens.home.SettingItem
import com.beeshop.app.ui.theme.BeeShopTheme


@ShowkaseComposable(name = "CartItemPreview", group = "Product")
@Composable
@Preview(showBackground = true)
fun CartItemPreview() {
    BeeShopTheme {
        CartProduct()
    }
}


@ShowkaseComposable(name = "ProductGridItem", group = "Product")
@Composable
@Preview(showBackground = true)
fun ProductGridItemPreview() {
    BeeShopTheme {
        HomeProduct()
    }
}

@Preview
@Composable
@ShowkaseComposable(name = "SettingGroupItem", group = "Setting")
fun SettingGroupPreview() {
    BeeShopTheme {
        SettingGroup {
            SettingItem("Setting With Arrow")
            SmallDivider()
            SettingItem("Setting Custom End", endWidget = {
                AppSwitch(value = false)
            })
            SmallDivider()
            SettingItem("Setting Custom End 2 ", endWidget = {
                Icon(
                    imageVector = Icons.Filled.OpenInNew,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            })
        }
    }
}

@Preview
@Composable
@ShowkaseComposable(name = "CategorySmall", group = "Product")
fun CategoryWidgetPreview(){
    BeeShopTheme {
        HomeCategoryWidget()
    }
}*/
