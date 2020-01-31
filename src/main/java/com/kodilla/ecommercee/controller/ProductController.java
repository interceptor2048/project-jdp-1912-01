package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupNotFoundException;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.DbProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private DbProductService dbProductService;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapTogProductDtoList(dbProductService.getAllProducts());
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(dbProductService.getProduct(productId));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        dbProductService.deleteProduct(productId);
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException, GroupNotFoundException {
        return productMapper.mapToProductDto(dbProductService.updateProduct(
                productDto.getId(),
                productMapper.mapToProduct(productDto)));
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) throws GroupNotFoundException {
        dbProductService.createProduct(productMapper.mapToProduct(productDto));
    }
}
