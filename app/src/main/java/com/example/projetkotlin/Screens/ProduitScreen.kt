package com.example.projetkotlin.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.projetkotlin.Components.FilterChip
import com.example.projetkotlin.Components.PinkGradientBackground
import com.example.projetkotlin.Components.ProductCard
import com.example.projetkotlin.Navigation.Screen
import com.example.projetkotlin.data.product
import com.example.projetkotlin.ui.theme.PinkPrimary
import com.example.projetkotlin.data.sampleProducts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProduitScreen(navController: NavController, products: List<product>, onProductClick: (Int) -> Unit, onBack: () -> Unit) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cat Supplies", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PinkPrimary
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = PinkPrimary
            ) {
                NavigationBarItem(
                    selected = currentRoute == Screen.Home.route,
                    onClick = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    label = { Text("Home", color = Color.White) }
                )

                NavigationBarItem(
                    selected = currentRoute == Screen.Produit.route,
                    onClick = {
                        navController.navigate(Screen.Produit.route) {
                            popUpTo(Screen.Produit.route) { inclusive = true }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.List,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    label = { Text("Categories", color = Color.White) }
                )
                NavigationBarItem(
                    selected = currentRoute == Screen.Cart.route,
                    onClick = {
                        navController.navigate(Screen.Cart.route) {
                            popUpTo(Screen.Cart.route) { inclusive = true }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    label = { Text("Cart", color = Color.White) }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    label = { Text("Profile", color = Color.White) }
                )
            }
        }
    ) { innerPadding ->

        PinkGradientBackground {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {

                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    FilterChip("All")
                    FilterChip("cat food")
                    FilterChip("cat treats")
                }

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(sampleProducts) { product ->
                        ProductCard(product = product, onClick = { onProductClick(product.id) })
                    }
                }
            }
        }
    }
}