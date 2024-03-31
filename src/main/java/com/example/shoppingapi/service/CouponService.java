package com.example.shoppingapi.service;

import com.example.shoppingapi.payload.ListApiResponse;
import com.example.shoppingapi.payload.CouponResponseDto;

public interface CouponService {
    ListApiResponse<CouponResponseDto> findAllCoupons();
}
