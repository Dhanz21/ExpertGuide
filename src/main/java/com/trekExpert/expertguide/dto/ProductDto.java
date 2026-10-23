package com.trekExpert.expertguide.dto;

import java.math.BigDecimal;

public record ProductDto(Long id, String name, Integer qtyAvailable, BigDecimal price) {
}
