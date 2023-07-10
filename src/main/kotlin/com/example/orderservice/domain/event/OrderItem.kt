package com.example.orderservice.domain.event

data class OrderItem(
    var productId:String,
    var productCount: Int,
    var unitPrice:Double,
    var totalPrice:Int
)
