package com.jetbrains.kmpapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jetbrains.kmpapp.screens.auth.LoginScreen
import com.jetbrains.kmpapp.screens.detail.DetailScreen
import com.jetbrains.kmpapp.screens.home.HomeScreen
import com.jetbrains.kmpapp.screens.product.ProductDetailScreen
import kotlinx.serialization.Serializable

@Serializable
object LoginDestination

@Serializable
object HomeScreenTabDestination


@Serializable
object ProductDetailDestination


@Serializable
data class DetailDestination(val objectId: Int)

@Composable
fun App() {

    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            val navController: NavHostController = rememberNavController()
            fun onBackPress() {
                navController.navigateUp()
            }
            NavHost(navController = navController, startDestination = HomeScreenTabDestination) {
                composable<LoginDestination> {
                    LoginScreen()
                }
                composable<HomeScreenTabDestination> {
                    HomeScreen(rootNavController = navController)
                }

                composable<ProductDetailDestination> {
                    ProductDetailScreen(productId = "", navigateBack = {
                        onBackPress()
                    })
                }

                composable<DetailDestination> { backStackEntry ->
                    DetailScreen(
                        objectId = backStackEntry.toRoute<DetailDestination>().objectId,
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
