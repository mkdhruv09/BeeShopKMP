/*
package com.beeshop.app.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.beeshop.app.ui.theme.BeeShopTheme
import com.jetbrains.kmpapp.theme.BeeShopTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@ShowkaseComposable(name = "Avatar", group = "CommonComponents")
@Preview(showBackground = true)
fun AvatarPreview() {
    BeeShopTheme {
        Avatar(modifier = Modifier.size(100.dp))
    }
}

@ShowkaseComposable(name = "AppDialog", group = "CommonComponents")
@Preview
@Composable
fun AppDialogContentPreview() {
    BeeShopTheme {
        AppDialogContent(
            title = "Logout Confirmation?",
            message = "Are you sure want to logout?",
            positiveAction = Pair("Okay", {}),
            negativeAction = Pair("Cancel", {})
        )
    }
}

@ShowkaseComposable(name = "RatingBar", group = "CommonComponents")
@Preview
@Composable
fun RatingBarPreview() {
    BeeShopTheme {
        RatingBar(rating = 3.5)
    }
}

@ShowkaseComposable(name = "ListHeader", group = "CommonComponents")
@Preview(showBackground = true)
@Composable
fun ListHeaderPreview() {
    BeeShopTheme {
        ListHeader()
    }
}

@ShowkaseComposable(name = "SmallDividerLight", group = "CommonComponents")
@Preview(showBackground = true)
@Composable
fun SmallDividerLightPreview() {
    BeeShopTheme {
        SmallDividerLight()
    }
}

@ShowkaseComposable(name = "SmallDivider", group = "CommonComponents")
@Preview(showBackground = true)
@Composable
fun SmallDividerPreview() {
    BeeShopTheme {
        SmallDivider()
    }
}


@ShowkaseComposable(name = "AppOutlineButton", group = "CommonComponents")
@Composable
fun AppOutlineButtonPreview() {
    BeeShopTheme {
        AppOutlinedButton()
    }
}

@ShowkaseComposable(name = "AppToolBar", group = "CommonComponents")
@Composable
@Preview
fun AppToolbarPreview() {
    BeeShopTheme {
        AppToolbar(title = "BeeShop", showBack = true)
    }
}

@ShowkaseComposable(name = "SearchView", group = "CommonComponents")
@Composable
@Preview(showBackground = true)
fun SearchViewPreview() {
    BeeShopTheme {
        SearchView(text = "Search Here")
    }
}

@ShowkaseComposable(name = "AppNavigationBar", group = "CommonComponents")
@Composable
@Preview
fun AppNavigationBarPreview() {
    BeeShopTheme {
        AppNavigationBar()
    }
}

@ShowkaseComposable(name = "FullButton", group = "CommonComponents")
@Composable
@Preview
fun FullButtonPreview() {
    BeeShopTheme {
        FullButton()
    }
}

@ShowkaseComposable(name = "NoDataView", group = "CommonComponents")
@Composable
@Preview(showBackground = true)
fun NoDataViewPreview() {
    BeeShopTheme {
        NoDataView()
    }
}

@ShowkaseComposable(name = "AppTextField", group = "CommonComponents")
@Composable
@Preview(showBackground = true)
fun AppTextFieldPreview() {
    BeeShopTheme {
        AppTextField(placeHolder = "Text here")
    }
}

@ShowkaseComposable(name = "AppOutlineButton", group = "CommonComponents")
@Composable
@Preview(showBackground = true)
fun AppOutlinedButtonPreview() {
    BeeShopTheme {
        AppOutlinedButton()
    }
}

//@ShowkaseComposable(name = "AppButton", group = "CommonComponents")
@Composable
@Preview(showBackground = true)
fun AppButtonPreview() {
    BeeShopTheme {
        Column {
            Row {
                AppButton(text = "Normal Button")
                Spacer(modifier = Modifier.width(15.dp))
                AppButton(text = "Icon Button", icon = Icons.Filled.AddTask)
            }
            Row {
                AppButton(
                    text = "Normal Disable",
                    isEnabled = false
                )
                Spacer(modifier = Modifier.width(15.dp))
                AppButton(
                    text = "Icon Disable",
                    icon = Icons.Filled.AddTask,
                    isEnabled = false
                )
            }
        }
    }
}

//@ShowkaseComposable(name = "ChipViews", group = "CommonComponents")
@Composable
@Preview()
fun ChipViewsPreview() {
    BeeShopTheme {
        ChipViews(arrayListOf("S", "M", "L", "XL", "XXL"))
    }
}

//@ShowkaseComposable(name = "Switch", group = "CommonComponents")
@Composable
@Preview()
fun SwitchPreview() {
    BeeShopTheme {
        Row {
            AppSwitch(value = false)
            Spacer(modifier = Modifier.width(20.dp))
            AppSwitch(value = true)
        }
    }
}


//@ShowkaseComposable(name = "BottomSheet", group = "CommonComponents")
@Composable
@Preview()
fun BottomSheetPreview() {
    BeeShopTheme {
        BottomSheetContainer(title = "BottomSheet Title", modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.height(100.dp).fillMaxWidth()) {
                Text(
                    text = "BottomSheet Content",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }
        }
    }
}
*/
