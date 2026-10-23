package com.trekExpert.expertguide.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderDto(Long id, Long customerId, List<ProductDto> products, BigDecimal totalPrice, BigDecimal deliveryPrice) {
}
