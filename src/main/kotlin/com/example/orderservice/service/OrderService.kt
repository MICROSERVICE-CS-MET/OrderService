package com.example.orderservice.service

import com.example.orderservice.domain.model.Order
import com.example.orderservice.exception.NotFoundException
import com.example.orderservice.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    suspend fun findByUserId(userId: String): List<Order> {
        return orderRepository.findByUserId(userId)
    }
    fun handleReceivedOrder(order: Order) {
        val totalPrice = getTotalPriceFromOrder(order)
        order.totalPrice = totalPrice
        orderRepository.save(order)
    }

    suspend fun cancelOrder(id: String) {
        var order = getOrderById(id)
        order.isCanceled = true
        orderRepository.save(order)
    }

    private fun getOrderById(id: String): Order {
        var order = orderRepository.findById(id)
        if (order.isPresent) {
            return order.get()
        }
        throw NotFoundException("Order Not Found")
    }
    private fun getTotalPriceFromOrder(order: Order): Double {
        var totalPrice = 0.0
        for (orderItem in order.orderItems) {
            totalPrice += orderItem.totalPrice!!
        }
        return totalPrice
    }
}
