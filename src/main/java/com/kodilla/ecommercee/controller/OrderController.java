package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.DbOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order")
public class OrderController {
    private final DbOrderService dbOrderService;
    private final OrderMapper orderMapper;

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(dbOrderService.getAllOrders());
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws UserNotFoundException {
        return orderMapper.mapToOrderDto(dbOrderService.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        dbOrderService.deleteOrder(orderId);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) throws OrderNotFoundException, UserNotFoundException {
        return orderMapper.mapToOrderDto(dbOrderService.updateOrder(
                orderDto.getId(),
                orderMapper.mapToOrder(orderDto)));
    }

    @PostMapping(value = "createOrder")
    public void addOrder(@RequestBody OrderDto orderDto) throws UserNotFoundException {
        dbOrderService.createOrder(orderMapper.mapToOrder(orderDto));
    }
}
