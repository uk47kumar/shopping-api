package com.example.shoppingapi.service.impl;

import com.example.shoppingapi.entity.Coupon;
import com.example.shoppingapi.payload.ListApiResponse;
import com.example.shoppingapi.payload.CouponResponseDto;
import com.example.shoppingapi.repository.CouponRepository;
import com.example.shoppingapi.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;

    @Override
    public ListApiResponse<CouponResponseDto> findAllCoupons() {

        List<Coupon> coupons = couponRepository.findAll();

        List<CouponResponseDto> couponResponseDtoList = coupons
                .stream()
                .map(coupon -> mapToDto(coupon))
                .collect(Collectors.toList());

        return new ListApiResponse<>(200, couponResponseDtoList);
    }

    private CouponResponseDto mapToDto(Coupon coupon) {
        return modelMapper.map(coupon, CouponResponseDto.class);
    }
}
