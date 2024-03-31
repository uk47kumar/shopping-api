package com.example.shoppingapi.payload;

import com.example.shoppingapi.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {

    private Long userId;
    private Long orderId;
    private String transactionId;
    private OrderStatus status;
}
