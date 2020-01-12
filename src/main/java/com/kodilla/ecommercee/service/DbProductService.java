package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbProductService {
    private final ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product product) throws ProductNotFoundException {
        Product toUpdate = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        toUpdate.setProductName(product.getProductName());
        toUpdate.setProductType(product.getProductType());
        toUpdate.setGroup(product.getGroup());
        return productRepository.save(toUpdate);
    }

    public Optional<Product> getProduct(final Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(final Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }
}
