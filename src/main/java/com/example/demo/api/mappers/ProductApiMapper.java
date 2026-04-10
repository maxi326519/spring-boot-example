package com.example.demo.api.mappers;

import com.example.demo.api.dto.response.ProductResponse;
import com.example.demo.model.Product;

public class ProductApiMapper {
    public static ProductResponse toResponse(Product p) {
        return new ProductResponse(p.id(), p.name());
    }
}