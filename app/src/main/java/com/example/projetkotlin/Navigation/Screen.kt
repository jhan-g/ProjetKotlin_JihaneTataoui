package com.example.projetkotlin.Navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Produit : Screen("produit")
    object Detail : Screen("detail/{productId}") {
        fun createRoute(productId: Int) = "detail/$productId"
    }
    object Cart : Screen("cart")
}
