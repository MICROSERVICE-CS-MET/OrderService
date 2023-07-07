package com.example.orderservice.controller

import com.example.orderservice.domain.model.Order
import com.example.orderservice.service.OrderService
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController (
    private val orderService: OrderService
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