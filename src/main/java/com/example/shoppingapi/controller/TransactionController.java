package com.example.shoppingapi.controller;

import com.example.shoppingapi.payload.TransactionDto;
import com.example.shoppingapi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/{userId}/{orderId}/pay")
    public ResponseEntity<TransactionDto> createTransaction(
            @PathVariable("userId") Long userId,
            @PathVariable("orderId") Long orderId,
            @RequestParam double amount) {
        TransactionDto transactionDto = transactionService.createTransaction(userId, orderId, amount);
        return new ResponseEntity<>(transactionDto, OK);
    }
}
