package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartNotFoundException;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCartService {
    @Autowired
    private  CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;


    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCart(final Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
    }

    public Cart addProductToCart(final Long cartId, final Long productId){
        Cart cartToAddProduct = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        cartToAddProduct.getProducts().add(productRepository.findById(productId).orElseThrow(ProductNotFoundException::new));
        return cartRepository.save(cartToAddProduct);
    }

    public Cart removeProductFromCart(final Long cartId, final Long productId){
        Cart cartToAddProduct = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        cartToAddProduct.getProducts().remove(productRepository.findById(productId).orElseThrow(ProductNotFoundException::new));
        return cartRepository.save(cartToAddProduct);
    }
}
