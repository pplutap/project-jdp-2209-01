package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;

public class ProductMapper {

    private ProductMapper(){};

    public static ProductDto mapToDto(Product product){
        return new ProductDto(product.getId(),
                                product.getName(),
                                product.getDescription(),
                                product.getPrice(),
                                product.getGroup(),
                                product.getVersion()
                                );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(productDto.getId(),
                            productDto.getName(),
                            productDto.getDescription(),
                            productDto.getPrice(),
                            productDto.getGroup(),
                            productDto.getVersion());
    }


}
