package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.exceptions.ProdctNotFoundException;
import com.kodilla.ecommercee.mappers.ProductMapper;
import com.kodilla.ecommercee.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.ecommercee.mappers.ProductMapper.mapToDto;
import static com.kodilla.ecommercee.mappers.ProductMapper.mapToProduct;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getAllProducts(){
        return productRepository.findAll().stream()
                                        .map(ProductMapper::mapToDto)
                                        .collect(Collectors.toList());
    }

    public ProductDto getProductById( Long id) throws ProdctNotFoundException {
       return productRepository.findById(id).map(ProductMapper::mapToDto)
                                .orElseThrow(ProdctNotFoundException::new);
    }

    public ProductDto addProduct(ProductDto productDto){

        Product savedProduct = productRepository.save(mapToProduct(productDto));
        //TODO jak group service zostanie zaakceptowany to dodać do bazy danych grupę jeżeli nie ma jej w bazie
        return mapToDto(savedProduct);
    }

    public ProductDto updateProduct(ProductDto productDto) throws ProdctNotFoundException {
        if(!productRepository.existsById(productDto.getId()))
            throw new ProdctNotFoundException();

        Product savedProduct = productRepository.save(mapToProduct(productDto));
        //TODO jak group service zostanie zaakceptowany to dodać do bazy danych grupę jeżeli nie ma jej w bazie
        return mapToDto(savedProduct);
    }

    public void deleteProduct(Long id) throws ProdctNotFoundException {
        if(!productRepository.existsById(id))
            throw new ProdctNotFoundException();

        productRepository.deleteById(id);
    }

}
