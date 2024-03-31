package com.example.shoppingapi.service.impl;

import com.example.shoppingapi.entity.Order;
import com.example.shoppingapi.entity.Transaction;
import com.example.shoppingapi.entity.User;
import com.example.shoppingapi.exception.ResourceNotFoundException;
import com.example.shoppingapi.exception.ShoppingApiException;
import com.example.shoppingapi.payload.TransactionDto;
import com.example.shoppingapi.repository.OrderRepository;
import com.example.shoppingapi.repository.TransactionRepository;
import com.example.shoppingapi.repository.UserRepository;
import com.example.shoppingapi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.example.shoppingapi.utils.OrderStatus.*;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public TransactionDto createTransaction(Long userId, Long orderId, double amount) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

        if (amount != order.getAmount()) {
            throw new ShoppingApiException("Invalid transaction amount: Amount does not match the order total");
        }

        Transaction transaction = new Transaction();
        String transactionId = "tran" + System.currentTimeMillis();
        transaction.setTransactionId(transactionId);
        transaction.setUser(user);
        transaction.setOrder(order);
        transaction.setStatus(SUCCESSFUL);

        transactionRepository.save(transaction);

        order.setTransactionId(transactionId);
        orderRepository.save(order);

        return mapToDto(transaction);
    }

    private TransactionDto mapToDto(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDto.class);
    }
}
