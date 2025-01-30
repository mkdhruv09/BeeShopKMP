package com.jetbrains.kmpapp.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetbrains.kmpapp.ProductDetailDestination
import com.jetbrains.kmpapp.components.AppNavigationBar
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppToolbar
import com.jetbrains.kmpapp.components.BottomBarDestination
import com.jetbrains.kmpapp.theme.BeeShopTheme
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.label_medium
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun HomeScreen(rootNavController: NavHostController) {
    BeeShopTheme {
        val navController = rememberNavController()
        val appName = stringResource(Res.string.label_medium)
        var title by remember {
            mutableStateOf("home")
        }
        val navItems =
            listOf(
                BottomBarDestination(title = "Home", icon = Icons.Filled.Home, key = "home"),
                BottomBarDestination(title = "Reels", icon = Icons.Filled.PlayArrow, key = "reels"),
                BottomBarDestination(
                    title = "Category",
                    icon = Icons.Filled.Place,
                    key = "category"
                ),
                BottomBarDestination(
                    title = "Notifications",
                    icon = Icons.Filled.Notifications,
                    key = "notification"
                ),
                BottomBarDestination(
                    title = "Settings",
                    icon = Icons.Filled.Settings,
                    key = "setting"
                )
            )
        AppScreenScaffold(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            topBar = {
                AppToolbar(title = title)
            },
            bottomBar = {
                AppNavigationBar(onNavigationChange = {
                    title = it
                    when (it) {
                        "home" -> {
                            navController.navigate(DashboardDestination)
                        }

                        "reels" -> {
                            navController.navigate(ReelsTabScreenDestination)
                        }

                        "setting" -> {
                            navController.navigate(SettingDestination)
                        }
                    }

                }, listItems = navItems, selected = title)
            },
        ) {
            HomeNavHost(
                navController = navController,
                rootNavController = rootNavController,
            )
        }
    }
}

@Serializable
object DashboardDestination

@Serializable
object SettingDestination

@Serializable
object ReelsTabScreenDestination

@Composable
fun HomeNavHost(
    navController: NavHostController,
    rootNavController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = DashboardDestination
    ) {
        composable<DashboardDestination> {
            DashboardTabScreen(onProductDetail = {
                rootNavController.navigate(ProductDetailDestination)
            }, onReelsClick = {
                navController.navigate(ReelsTabScreenDestination)
            })
        }
        composable<ReelsTabScreenDestination> {
            ReelsTabScreen()
        }
        composable<SettingDestination> {
            SettingTabScreen()
        }
    }
}