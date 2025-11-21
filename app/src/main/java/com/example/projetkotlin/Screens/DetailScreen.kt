package com.example.projetkotlin.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.projetkotlin.Components.PinkGradientBackground
import com.example.projetkotlin.Navigation.Screen
import com.example.projetkotlin.data.product
import com.example.projetkotlin.ui.theme.PinkPrimary
import com.example.projetkotlin.ui.theme.blue
import com.example.projetkotlin.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, product: product, onBack: () -> Unit, onAddToCart: () -> Unit,  onNavigateToCart: () -> Unit) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(product.title.take(25) + "...", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Share, contentDescription = null, tint = Color.White)
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
                    )}

        }
    ) { innerPadding ->

        PinkGradientBackground {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {

                Image(
                    painter = painterResource(product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(product.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)

                Text(
                    product.recommend,
                    color = Color(0xFFE91E63),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                Text(
                    product.description,
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    lineHeight = 20.sp,

                    )

                Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                onAddToCart()
                                onNavigateToCart()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = blue)
                        ) {
                            Text("Add to Cart", color = white, fontWeight = FontWeight.Bold)
                        }
            }
        }
    }
}

