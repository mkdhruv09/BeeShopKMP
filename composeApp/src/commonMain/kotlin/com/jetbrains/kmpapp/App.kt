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
import com.jetbrains.kmpapp.screens.auth.LoginScreen
import com.jetbrains.kmpapp.screens.auth.OtpVerificationScreen
import com.jetbrains.kmpapp.screens.checkout.CartScreen
import com.jetbrains.kmpapp.screens.checkout.PaymentSuccessScreen
import com.jetbrains.kmpapp.screens.home.HomeScreen
import com.jetbrains.kmpapp.screens.product.ProductDetailScreen
import kotlinx.serialization.Serializable

@Serializable
object LoginDestination

@Serializable
object OtpVerificationDestination

@Serializable
object HomeScreenTabDestination


@Serializable
object ProductDetailDestination

@Serializable
object CartDestination

@Serializable
object PaymentDestination


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
            NavHost(navController = navController, startDestination = LoginDestination) {

                composable<LoginDestination> {
                    LoginScreen(onValidateLogin = {
                        navController.navigate(OtpVerificationDestination)
                    })
                }
                composable<OtpVerificationDestination> {
                    OtpVerificationScreen(onVerifyOtp = {
                        navController.navigate(HomeScreenTabDestination)
                    })
                }
                composable<HomeScreenTabDestination> {
                    HomeScreen(rootNavController = navController)
                }

                composable<ProductDetailDestination> {
                    ProductDetailScreen(productId = "", navigateBack = {
                        onBackPress()
                    }, onCartRedirect = {
                        navController.navigate(CartDestination)
                    })
                }

                composable<CartDestination> {
                    CartScreen(onBack = {
                        onBackPress()
                    }, onNavigatePayment = {
                        navController.navigate(PaymentDestination)
                    })
                }


                composable<PaymentDestination> {
                    PaymentSuccessScreen(onHomeRedirect = {
                        navController.popBackStack(HomeScreenTabDestination, inclusive = false)
                    })
                }
            }
        }
    }
}
