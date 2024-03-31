package com.example.shoppingapi.service;

import com.example.shoppingapi.entity.Transaction;
import com.example.shoppingapi.payload.TransactionDto;

public interface TransactionService {

    TransactionDto createTransaction(Long userId, Long orderId, double amount);
}
