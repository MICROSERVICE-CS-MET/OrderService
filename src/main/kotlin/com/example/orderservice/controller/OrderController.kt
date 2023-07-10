package com.example.orderservice.controller

import com.example.orderservice.domain.model.Order
import com.example.orderservice.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController (
    private val orderService: OrderService,
){
    @GetMapping("/{userId}")
    suspend fun findByUserId(@PathVariable("userId")userId:String):List<Order>{
        return orderService.findByUserId(userId)
    }
    @PostMapping("")
    suspend fun save(@RequestBody order: Order):Order{
        return orderService.save(order)
    }
    @DeleteMapping("/cancelOrder/{orderId}")
    suspend fun cancelOrder(@PathVariable("orderId") orderId: String):ResponseEntity<String>{
        orderService.cancelOrder(orderId)
        return ResponseEntity.ok("Order Canceled!")
    }

}

