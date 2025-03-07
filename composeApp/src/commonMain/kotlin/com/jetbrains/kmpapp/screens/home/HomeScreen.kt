package com.jetbrains.kmpapp.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetbrains.kmpapp.ProductDetailDestination
import com.jetbrains.kmpapp.components.AppNavigationBar
import com.jetbrains.kmpapp.components.AppScreenScaffold
import com.jetbrains.kmpapp.components.AppToolbar
import com.jetbrains.kmpapp.components.BottomBarDestination
import com.jetbrains.kmpapp.screens.empty.EmptyScreenContent
import com.jetbrains.kmpapp.screens.category.ProductsTabScreen
import com.jetbrains.kmpapp.theme.BeeShopTheme
import io.github.aakira.napier.Napier
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun HomeScreen(rootNavController: NavHostController) {
    BeeShopTheme {
        val navController = rememberNavController()
        var title by remember {
            mutableStateOf("home")
        }
        val navItems =
            listOf(
                BottomBarDestination(
                    title = "Home",
                    icon = Icons.Filled.Home,
                    key = "home",
                ),
                BottomBarDestination(
                    title = "Reels",
                    icon = Icons.Filled.PlayArrow,
                    key = "reels"
                ),
                BottomBarDestination(
                    title = "Category",
                    icon = Icons.Filled.Face,
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

                        "notification" -> {
                            navController.navigate(NotificationDestination)
                        }

                        "category" -> {
                            navController.navigate(CategoryDestination)
                        }
                    }

                }, listItems = navItems, selected = title)
            },
        ) { paddingValues ->
            HomeNavHost(
                modifier = Modifier.padding(paddingValues),
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

@Serializable
object NotificationDestination

@Serializable
object CategoryDestination


@Composable
fun HomeNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    rootNavController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = DashboardDestination
    ) {
        composable<DashboardDestination> {
            DashboardTabScreen(onProductDetail = {
                Napier.d(message = "OnClick")
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

        composable<NotificationDestination> {
            EmptyScreenContent()
        }

        composable<CategoryDestination> {
            ProductsTabScreen()
        }
    }
}
