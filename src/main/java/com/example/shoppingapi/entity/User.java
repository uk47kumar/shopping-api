package com.example.shoppingapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(name = "applied_coupon_id")
    private Long appliedCouponId; // Foreign key referencing the applied coupon

    @OneToOne
    @JoinColumn(name = "applied_coupon_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Coupon appliedCoupon;

    @OneToMany(mappedBy = "userId")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

}
