package com.example.shoppingapi.repository;

import com.example.shoppingapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
