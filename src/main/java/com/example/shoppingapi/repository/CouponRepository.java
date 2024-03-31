package com.example.shoppingapi.repository;

import com.example.shoppingapi.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
    Optional<Coupon> findByCode(String code);
}
