package com.trekExpert.expertguide.dto;

import java.util.List;

public record OrderDto(Long id, Long customerId, List<ProductDto> products) {
}
