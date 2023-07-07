package com.example.orderservice.domain.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Order(
    @Id val id : String?=null,
    var userId: String,
    var orderItems : List<OrderItem>,
    var isCanceled: Boolean
)
