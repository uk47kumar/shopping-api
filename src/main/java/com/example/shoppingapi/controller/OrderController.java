package com.example.shoppingapi.controller;

import com.example.shoppingapi.entity.User;
import com.example.shoppingapi.exception.ResourceNotFoundException;
import com.example.shoppingapi.payload.ListApiResponse;
import com.example.shoppingapi.payload.OrderResponseDto;
import com.example.shoppingapi.payload.OrderTransactionDto;
import com.example.shoppingapi.payload.SingleItemApiResponse;
import com.example.shoppingapi.repository.UserRepository;
import com.example.shoppingapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;

    // there is no need of using @AutoWired through constructor because
    // I am using lombok annotation @RequiredArgsConstructor it automatically injects
    // dependency injection through constructor

    @PostMapping("/{userId}/order")
    public ResponseEntity<SingleItemApiResponse<OrderResponseDto>> createOrder(
            @PathVariable("userId") Long userId,
            @RequestParam(defaultValue = "${order.default-quantity}") int qty,
            @RequestParam(required = false) String coupon) {

        OrderResponseDto orderResponseDto = orderService.createOrder(userId, qty, coupon).getData();
        SingleItemApiResponse<OrderResponseDto> apiResponse = new SingleItemApiResponse<>(OK.value(), orderResponseDto);
        return new ResponseEntity<>(apiResponse, OK);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<ListApiResponse<OrderResponseDto>> getUserOrders(
            @PathVariable("userId") Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        List<OrderResponseDto> orderResponseDto = orderService.getUserOrders(user).getData();
        ListApiResponse<OrderResponseDto> apiResponse = new ListApiResponse<>(OK.value(), orderResponseDto);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<SingleItemApiResponse<OrderTransactionDto>> getUserOrder(
            @PathVariable("userId") Long userId,
            @PathVariable("orderId") Long orderId) {

        OrderTransactionDto orderResponseDto = orderService.getUserOrder(userId, orderId).getData();
        SingleItemApiResponse<OrderTransactionDto> apiResponse = new SingleItemApiResponse<>(OK.value(), orderResponseDto);
        return ResponseEntity.ok(apiResponse);
    }

}
