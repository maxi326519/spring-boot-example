package com.example.demo.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(
        @NotBlank
        String id,
        @NotBlank
        String name
) {}