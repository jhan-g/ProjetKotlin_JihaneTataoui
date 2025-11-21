package com.example.projetkotlin.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.projetkotlin.data.product
import com.example.projetkotlin.data.sampleProducts

class ShopViewModel : ViewModel() {
    val products: List<product> = sampleProducts

    private val _cart = mutableStateListOf<product>()
    val cart: List<product> = _cart

    fun addToCart(product: product) {
        _cart.add(product)
    }

    fun removeFromCart(product: product) {
        _cart.remove(product)
    }

    fun getProductById(id: Int): product? {
        return products.find { it.id == id }
    }
}