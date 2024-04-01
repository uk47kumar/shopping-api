package com.example.shoppingapi.payload;

import com.example.shoppingapi.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private List<Order> orders;
}
