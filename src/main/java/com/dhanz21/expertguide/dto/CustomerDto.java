package com.dhanz21.expertguide.dto;

import java.math.BigDecimal;

public record CustomerDto(Long id, String name, BigDecimal price, BigDecimal deliveryPrice) {
}
