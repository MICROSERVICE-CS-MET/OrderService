package com.example.orderservice.controller

import com.example.orderservice.domain.dto.response.OrderResponse
import com.example.orderservice.domain.mapper.OrderMapper
import com.example.orderservice.service.OrderService
import org.mapstruct.factory.Mappers
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping("/findByUserId/{userId}")
    suspend fun findByUserId(@PathVariable("userId")userId: String): List<OrderResponse> {
        val converter = Mappers.getMapper(OrderMapper::class.java)
        return converter.ordersToOrdersResponse(orderService.findByUserId(userId))
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    suspend fun cancelOrder(@PathVariable("orderId") orderId: String): ResponseEntity<String> {
        orderService.cancelOrder(orderId)
        return ResponseEntity.ok("Order Canceled!")
    }
}
