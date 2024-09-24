package com.microservices.product_services.controller;

import com.microservices.product_services.dto.ProductRequest;
import com.microservices.product_services.dto.ProductResponse;
import com.microservices.product_services.manager.ProductServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceManager productServiceManager;

    @PostMapping
    public ProductResponse addProducts(@RequestBody ProductRequest productRequest) {
        ProductResponse response = productServiceManager.addProduct(productRequest);
        return response;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return productServiceManager.getAllProducts();
    }
}
