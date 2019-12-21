package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @PostMapping(value = "createCart")
    public void createCart(@RequestParam CartDto cartDto) {
    }

    @GetMapping(value = "getCartProducts")
    public List<Product> getCartProducts(@RequestParam Long cartId) {
        return new ArrayList<>();
    }

    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestParam Long cartId, @RequestParam Long productId) {

    }

    @DeleteMapping(value = "removeProductFromCart")
    public void removeProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) {

    }

    @PostMapping(value = "createOrderBasedOnCart")
    public OrderDto createOrderBasedOnCart(CartDto cartDto) {
        return new OrderDto(1L, "TestOrder");
    }
}
