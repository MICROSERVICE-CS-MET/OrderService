package com.example.orderservice.repository

import com.example.orderservice.domain.model.Order
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface OrderRepository : MongoRepository<Order, String> {
    fun findByUserId(userId: String): List<Order>
    override fun findById(id: String): Optional<Order>
}
