package com.microservices.product_services.manager;

import com.microservices.product_services.dto.ProductRequest;
import com.microservices.product_services.dto.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductServiceManager {
     ProductResponse addProduct(ProductRequest productRequest);

     List<ProductResponse> getAllProducts();
}
