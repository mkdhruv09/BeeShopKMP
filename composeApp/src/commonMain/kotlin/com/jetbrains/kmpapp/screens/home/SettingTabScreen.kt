package com.jetbrains.kmpapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.components.AppDialog
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppSmallButton
import com.jetbrains.kmpapp.components.AppSwitch
import com.jetbrains.kmpapp.components.BORDER_WIDTH
import com.jetbrains.kmpapp.components.SmallDivider
import com.jetbrains.kmpapp.components.roundedBackground
import com.jetbrains.kmpapp.components.roundedBordered
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bee_banner
import org.jetbrains.compose.resources.painterResource

@Composable

fun SettingTabScreen() {
    AppScreenScaffold(containerColor = Color.White) { paddingValues ->
        var showLogoutConfirmation by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            SettingProfileAvatar(modifier = Modifier.size(100.dp))
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = "Krupal Mehta",
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(6.dp)
            )
            AppSmallButton(
                text = "Edit Profile", onClick = {
                    //localRootNavigation?.navigate(EditProfileScreenDestination)
                }
            )
            Spacer(modifier = Modifier.height(12.dp))

            SettingGroup {
                SettingItem(text = "My Orders",
                    icon = Icons.Outlined.ShoppingCart,
                    onClick = {
                        //localRootNavigation?.navigate(MyOrdersScreenDestination)
                    })
                SmallDivider()
                SettingItem(text = "Saved Addresses",
                    icon = Icons.Outlined.Home, onClick = {
                        //localRootNavigation?.navigate(SavedAddressScreenDestination)
                    })
                SmallDivider()
                SettingItem(text = "My Favorites",
                    icon = Icons.Outlined.FavoriteBorder,
                    onClick = {
                        //localRootNavigation?.navigate(MyFavoriteItemsScreenDestination)
                    })
            }

            SettingGroup {
                var notificationToggle by remember {
                    mutableStateOf(true)
                }
                SettingItem(
                    text = "Allow Notification",
                    icon = Icons.Outlined.Notifications,
                    endWidget = {
                        AppSwitch(value = notificationToggle, onValueChange = {
                            notificationToggle = it
                        })
                    })
                SmallDivider()
                SettingItem(
                    text = "My Rewards",
                    icon = Icons.Outlined.FavoriteBorder
                )
                SmallDivider()
                SettingItem(
                    text = "Refer & Earn",
                    icon = Icons.Outlined.Share
                )
            }

            SettingGroup {
                SettingItem(text = "Privacy Policy",
                    icon = Icons.Outlined.Search,
                    onClick = {
                        //launchPrivacyPolicy()
                    })
                SmallDivider()

                SettingItem(
                    text = "Terms & Conditions",
                    icon = Icons.Outlined.Call,
                    onClick = {
                        //launchTermsAndCondition()
                    })
                SmallDivider()

                SettingItem(text = "Refund Policy",
                    icon = Icons.Outlined.Warning,
                    onClick = {
                        //launchPrivacyPolicy()
                    })
                SmallDivider()

                SettingItem(
                    text = "Contact Us",
                    icon = Icons.Outlined.Call
                )
                SmallDivider()

                SettingItem(
                    text = "Delete My Account",
                    icon = Icons.Outlined.AccountCircle
                )
                SmallDivider()

                SettingItem(text = "Design System",
                    icon = Icons.Outlined.AccountCircle,
                    onClick = {
                        //localContext.startActivity(Showkase.getBrowserIntent(localContext))
                    })
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = "Logout from App",
                modifier = Modifier
                    .border(
                        width = BORDER_WIDTH,
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(100)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        showLogoutConfirmation = true
                    },
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        if (showLogoutConfirmation) {
            AppDialog(
                title = "Confirm Logout?",
                message = "Are you sure want to logout from App?",
                positiveAction = Pair("Okay") {},
                negativeAction = Pair("Cancel") {}, onDismiss = {
                    showLogoutConfirmation = false
                }
            )
        }
    }
}

@Composable
private fun SettingProfileAvatar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.35f)
            )
            .border(
                shape = CircleShape,
                width = BORDER_WIDTH,
                color = MaterialTheme.colorScheme.onPrimary
            )
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.BottomCenter)
                .size(150.dp),
            painter = painterResource(Res.drawable.bee_banner),
            contentDescription = "profile",
        )
    }
}

@Composable
fun SettingItem(
    text: String = "",
    icon: ImageVector = Icons.Outlined.Notifications,
    endWidget: (@Composable () -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onPrimary,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            modifier = Modifier,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.weight(1f))
        if (endWidget != null) {
            endWidget()
        } else {
            Icon(
                Icons.Filled.PlayArrow,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .size(16.dp)
            )
        }
    }
}

@Composable
fun SettingGroup(content: @Composable () -> Unit = {}) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 12.dp)
            .fillMaxWidth()
            .roundedBackground(MaterialTheme.colorScheme.primary.copy(alpha = 0.35f))
            .roundedBordered()
    ) {
        content()
    }
}


