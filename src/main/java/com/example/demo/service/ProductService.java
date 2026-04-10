package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductService {

    public static Product create(Long id, String name) {
        Product toSave = Product.create(id, name);
        return toSave;
    }
}
