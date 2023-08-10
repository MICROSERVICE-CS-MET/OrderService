package com.example.orderservice.domain.event

data class CompleteOrderEvent(
    var userId: String,
    var orderItems: List<OrderItem>,
    var totalPrice: Double
)
