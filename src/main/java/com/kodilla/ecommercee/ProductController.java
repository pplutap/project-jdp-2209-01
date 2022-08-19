package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return new ProductDto(1L, "test name", "test description", 123.45, 1L);
    }

    @PostMapping
    public void createProduct(ProductDto productDto) {

    }

    @PutMapping
    public ProductDto updateProduct(ProductDto productDto) {
        return new ProductDto(1L, "Edited test name", "Edited test description", 100.00, 1L);
    }

    @DeleteMapping
    public void deleteProduct(Long productId) {

    }
}
