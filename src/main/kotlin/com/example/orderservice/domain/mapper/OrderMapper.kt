package com.example.orderservice.domain.mapper

import com.example.orderservice.domain.dto.response.OrderResponse
import com.example.orderservice.domain.event.CompleteOrderEvent
import com.example.orderservice.domain.model.Order
import org.mapstruct.Mapper

@Mapper
interface OrderMapper {
    fun completeOrderEventToOrder(completeOrderEvent: CompleteOrderEvent): Order
    fun stringToOrderEvent(orderEvent: String): CompleteOrderEvent
    fun ordersToOrdersResponse(orders: List<Order>): List<OrderResponse>
}
