package com.example.demo.model;

public record Product(Long id, String name) {

    public static Product create(Long id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        return new Product(null, name.trim());
    }

    public Long id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }
}
