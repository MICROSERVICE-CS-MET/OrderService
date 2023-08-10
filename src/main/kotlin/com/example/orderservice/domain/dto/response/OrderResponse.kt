package com.example.orderservice.domain.dto.response

data class OrderResponse(
    val id: String,
    var userId: String,
    var orderItems: List<OrderItemResponse>,
    var totalPrice: Double,
    var isCanceled: Boolean
)
