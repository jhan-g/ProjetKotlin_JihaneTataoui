package com.example.projetkotlin.data

data class CartItem(
    val id: Int,
    val name: String,
    val price: Int,
    val image: Int,
    val discount: Boolean = false
)