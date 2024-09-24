package com.microservices.product_services.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponse {

    private Long productId;
    private String name;
}
