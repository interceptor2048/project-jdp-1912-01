package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.DbCartService;
import com.kodilla.ecommercee.service.DbOrderService;
import com.kodilla.ecommercee.service.DbProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @Autowired
    private DbCartService dbCartService;
    @Autowired
    private DbProductService dbProductService;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
        dbCartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getCartProducts")
    public List<ProductDto> getCartProducts(@RequestParam Long cartId) {
        return productMapper.mapTogProductDtoList(dbCartService.getCart(cartId).getProducts());
    }

    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestParam Long productId) {
        dbCartService.getCart(cartId).getProducts().add(dbProductService.getProduct(productId));
    }

    @DeleteMapping(value = "removeProductFromCart")
    public void removeProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) {
        dbCartService.getCart(cartId).getProducts().remove(dbProductService.getProduct(productId));
    }
}
