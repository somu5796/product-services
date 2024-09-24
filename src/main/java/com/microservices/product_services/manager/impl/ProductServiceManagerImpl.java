package com.microservices.product_services.manager.impl;

import com.microservices.product_services.dto.ProductRequest;
import com.microservices.product_services.dto.ProductResponse;
import com.microservices.product_services.manager.ProductServiceManager;
import com.microservices.product_services.model.Product;
import com.microservices.product_services.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductServiceManagerImpl implements ProductServiceManager {

    @Autowired
   private ProductRepository productRepository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
//        List<Product> products = productRequest.stream().map(this::mapDtoToEntity).toList();
        Product savedProducts = productRepository.save(mapDtoToEntity(productRequest));
//        return savedProducts.stream().map(this::mapEntityToDto).toList();
        return mapEntityToDto(savedProducts);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapEntityToDto).toList();
    }

    private ProductResponse mapEntityToDto(Product product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .name(product.getName())
                .build();
    }

    private Product mapDtoToEntity(ProductRequest productRequest) {
        return Product.builder()
                .description(productRequest.getDesc())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .build();

    }
}
