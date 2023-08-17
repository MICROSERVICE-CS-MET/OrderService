package com.example.orderservice.domain.dto.response

data class OrderItemResponse(
    var productId: String,
    var productName:String?,
    var productCount: Int,
    var unitPrice: Double?,
    var totalPrice: Double?
)
