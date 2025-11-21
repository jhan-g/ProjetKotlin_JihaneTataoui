package com.example.projetkotlin.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.projetkotlin.ui.theme.PinkPrimary

@Composable
fun BottomBar(navController: NavController) {

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(containerColor = PinkPrimary) {

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { navController.navigate("home") },
            icon = { Icon(Icons.Default.Home, null, tint = Color.White) },
            label = { Text("Home", color = Color.White) }
        )

        NavigationBarItem(
            selected = currentRoute == "categories",
            onClick = { navController.navigate("categories") },
            icon = { Icon(Icons.Default.List, null, tint = Color.White) },
            label = { Text("Categories", color = Color.White) }
        )

        NavigationBarItem(
            selected = currentRoute == "cart",
            onClick = { navController.navigate("cart") },
            icon = { Icon(Icons.Default.ShoppingCart, null, tint = Color.White) },
            label = { Text("Cart", color = Color.White) }
        )
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { navController.navigate("profile") },
            icon = { Icon(Icons.Default.Person, null, tint = Color.White) },
            label = { Text("Profile", color = Color.White) }
        )
    }
}
