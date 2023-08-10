package com.example.orderservice.consumer

import com.example.orderservice.configuration.COMPLETE_ORDER_TOPIC
import com.example.orderservice.configuration.GROUP_ID
import com.example.orderservice.domain.event.CompleteOrderEvent
import com.example.orderservice.domain.mapper.OrderMapper
import com.example.orderservice.service.OrderService
import org.mapstruct.factory.Mappers
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class OrderConsumer(
    private val orderService: OrderService
) {
    @KafkaListener(topics = [COMPLETE_ORDER_TOPIC], groupId = GROUP_ID)
    fun completeOrderEventListener(completeOrderEvent: CompleteOrderEvent) {
        println(completeOrderEvent.userId)
        val converter = Mappers.getMapper(OrderMapper::class.java)
        val order = converter.completeOrderEventToOrder(completeOrderEvent)
        orderService.handleReceivedOrder(order)
    }
}
