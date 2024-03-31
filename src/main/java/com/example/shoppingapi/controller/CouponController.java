package com.example.shoppingapi.controller;

import com.example.shoppingapi.payload.ListApiResponse;
import com.example.shoppingapi.payload.CouponResponseDto;
import com.example.shoppingapi.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/fetchCoupons")
    public ResponseEntity<ListApiResponse<CouponResponseDto>> findAllCoupons(){
        List<CouponResponseDto> couponResponseDtoList = couponService.findAllCoupons().getData();
        ListApiResponse<CouponResponseDto> apiResponse = new ListApiResponse<>(OK.value(), couponResponseDtoList);
        return ResponseEntity.ok(apiResponse);
    }

}
