package com.example.shoppingapi.service;

import com.example.shoppingapi.payload.OrderResponseDto;
import com.example.shoppingapi.payload.SingleItemApiResponse;

public interface OrderService {

    SingleItemApiResponse<OrderResponseDto> createOrder(Long userId, int quantity, String coupon);
}
