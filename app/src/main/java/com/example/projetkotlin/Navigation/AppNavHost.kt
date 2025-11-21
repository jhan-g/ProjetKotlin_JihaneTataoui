package com.example.projetkotlin.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projetkotlin.Screens.CartScreen
import com.example.projetkotlin.Screens.DetailScreen
import com.example.projetkotlin.Screens.HomeScreen
import com.example.projetkotlin.Screens.LoginScreen
import com.example.projetkotlin.Screens.ProduitScreen
import com.example.projetkotlin.Screens.SignUpScreen
import com.example.projetkotlin.ViewModel.ShopViewModel

@Composable
fun AppNavHost() {

    val navController = rememberNavController()
    val shopViewModel: ShopViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(navController = navController, onGetStarted = {
                navController.navigate(Screen.Login.route)
            })
        }

        composable(Screen.Login.route) {
            LoginScreen(
                navController = navController,
                onNavigateToSignUp = { navController.navigate(Screen.SignUp.route) },
                onLoginSuccess = {
                    navController.navigate(Screen.Produit.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                onBack = { navController.navigate(Screen.Home.route) }
            )
        }

        composable(Screen.SignUp.route) {
            SignUpScreen(
                navController,
                onBack = { navController.popBackStack() }
            ) {
                navController.popBackStack()
            }
        }

        composable(Screen.Produit.route) {

                ProduitScreen(
                navController = navController,
                products = shopViewModel.products,
                onBack = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                onProductClick = { productId ->
                    navController.navigate(Screen.Detail.createRoute(productId))
                }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            val product = shopViewModel.getProductById(productId)
            product?.let {
                DetailScreen(
                    navController = navController,
                    product = it,
                    onBack = { navController.popBackStack() },
                    onAddToCart = { shopViewModel.addToCart(it) },
                    onNavigateToCart = { navController.navigate(Screen.Cart.route) }
                )
            }
        }

        composable(Screen.Cart.route) {
            CartScreen(
                navController = navController,
                cartItems = shopViewModel.cart,
                onBack = {
                    navController.navigate(Screen.Produit.route) {
                        popUpTo(Screen.Produit.route) { inclusive = true }
                    }
                },
                onRemoveItem = { shopViewModel.removeFromCart(it) }
            )
        }
    }
}
