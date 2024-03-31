package com.example.shoppingapi.payload;

import com.example.shoppingapi.entity.User;
import com.example.shoppingapi.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderResponseDto {
    private Long orderId;
    private Long userId;
    private int quantity;
    private double amount;
    private String coupon;
    private LocalDate date;
    private OrderStatus status;
}
