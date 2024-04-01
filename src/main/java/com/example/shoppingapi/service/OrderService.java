package com.example.shoppingapi.service;

import com.example.shoppingapi.entity.User;
import com.example.shoppingapi.payload.ListApiResponse;
import com.example.shoppingapi.payload.OrderResponseDto;
import com.example.shoppingapi.payload.OrderTransactionDto;
import com.example.shoppingapi.payload.SingleItemApiResponse;

import java.util.List;

public interface OrderService {

    SingleItemApiResponse<OrderResponseDto> createOrder(Long userId, int quantity, String coupon);
    ListApiResponse<OrderResponseDto> getUserOrders(User user);
    SingleItemApiResponse<OrderTransactionDto> getUserOrder(Long userId, Long orderId);
}
