package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {
        return new OrderDto(1L, "orderName");
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {

    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, "orderName");
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {

    }

}
