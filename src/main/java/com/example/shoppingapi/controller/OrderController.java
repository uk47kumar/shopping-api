package com.example.shoppingapi.controller;

import com.example.shoppingapi.payload.OrderResponseDto;
import com.example.shoppingapi.payload.SingleItemApiResponse;
import com.example.shoppingapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{userId}/order")
    public ResponseEntity<SingleItemApiResponse<OrderResponseDto>> createOrder(
            @PathVariable("userId") Long userId,
            @RequestParam(defaultValue = "${order.default-quantity}") int qty,
            @RequestParam(required = false) String coupon) {

        OrderResponseDto orderResponseDto = orderService.createOrder(userId, qty, coupon).getData();
        SingleItemApiResponse<OrderResponseDto> apiResponse = new SingleItemApiResponse<>(OK.value(), orderResponseDto);
        return new ResponseEntity<>(apiResponse, OK);
    }

}
