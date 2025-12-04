package com.korit.springboot.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int productId;
    private String productName;
    private String productSize;
    private int productPrice;
}
