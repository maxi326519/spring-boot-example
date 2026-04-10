package com.example.demo.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.dto.request.CreateProductRequest;
import com.example.demo.api.dto.response.ProductResponse;
import com.example.demo.api.mappers.ProductApiMapper;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@Valid @RequestBody CreateProductRequest body) {

        // Validar body
        if (body.id() == null) {
            throw new IllegalArgumentException("id is required");
        }
        if (body.name() == null || body.name().isBlank()) {
            throw new IllegalArgumentException("name is required");
        }

        Product created = productService.create(Long.parseLong(body.id()), body.name());

        return ProductApiMapper.toResponse(created);
    }
}
