package com.example.orderservice.domain.model

data class OrderItem(
    var productId : String,
    var productCount: Int,
    var unitPrice:Int,
    var totalPrice:Int
)
