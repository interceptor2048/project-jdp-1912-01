package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    DbUserService userService;
    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getId(),
                productMapper.mapToProductList(cartDto.getProducts()),
                userService.getUser(cartDto.getUserDto().getId()).orElseThrow(UserNotFoundException::new));
    }
}
