package com.trekExpert.expertguide.dto;

import java.math.BigDecimal;

public record ProductDto(String productId, String productName, Integer qtyAvailable, BigDecimal price) {
}
