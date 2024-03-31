package com.example.shoppingapi.service.impl;

import com.example.shoppingapi.entity.Coupon;
import com.example.shoppingapi.entity.Order;
import com.example.shoppingapi.entity.User;
import com.example.shoppingapi.exception.ResourceNotFoundException;
import com.example.shoppingapi.exception.ShoppingApiException;
import com.example.shoppingapi.payload.OrderResponseDto;
import com.example.shoppingapi.payload.SingleItemApiResponse;
import com.example.shoppingapi.repository.CouponRepository;
import com.example.shoppingapi.repository.OrderRepository;
import com.example.shoppingapi.repository.UserRepository;
import com.example.shoppingapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.example.shoppingapi.utils.OrderStatus.*;
import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;

    @Value("${order.default-quantity}")
    private int maxQuantity;

    @Override
    public SingleItemApiResponse<OrderResponseDto> createOrder(Long userId, int quantity, String coupon) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        if (quantity < 1 || quantity > maxQuantity) {
            throw new ShoppingApiException("Invalid quantity: Quantity must be between 1 and " + maxQuantity);
        }

        // Assuming price per item is 100
        double pricePerItem = 100;
        double totalAmount = quantity * pricePerItem;

        // checking coupon discount
        if (coupon != null && !coupon.isEmpty()) {

            Coupon appliedCoupon = couponRepository.findByCode(coupon)
                    .orElseThrow(() -> new ShoppingApiException("Invalid coupon"));

            int discountPercentage = appliedCoupon.getDiscountPercentage();
            double discountAmount = (totalAmount * discountPercentage) / 100.0;
            totalAmount -= discountAmount;
        }

        Order order = new Order();
        order.setQuantity(quantity);
        order.setCoupon(coupon);
        order.setDate(LocalDate.now());
        order.setUserId(user);
        order.setAmount(totalAmount);
        order.setStatus(SUCCESSFUL);

        orderRepository.save(order);

        OrderResponseDto responseDto = mapToDto(order);

        return new SingleItemApiResponse<>(OK.value(), responseDto);
    }

    private OrderResponseDto mapToDto(Order order) {
        return modelMapper.map(order, OrderResponseDto.class);
    }
}
