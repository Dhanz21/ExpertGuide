package com.trekExpert.expertguide.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderDto(String orderID, String customerId, List<ProductDto> products, BigDecimal totalPrice) {
}
