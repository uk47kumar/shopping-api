package com.example.shoppingapi.repository;

import com.example.shoppingapi.entity.Order;
import com.example.shoppingapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// there is no need of using @Repository because Jpa internally using SimpleJpaRepository
// and that SimpleJpaRepository already using @Repository annotation
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(User user);

    Optional<Order> findByUserIdAndId(User user, Long orderId);
}
