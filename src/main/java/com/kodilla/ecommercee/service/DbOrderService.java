package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbOrderService {
    private final OrderRepository orderRepository;

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(final Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(final Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        }
    }

    public Order updateOrder(Long orderId, Order order) throws OrderNotFoundException {
        Order toUpdate = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        toUpdate.setOrderName(order.getOrderName());
        toUpdate.setUser(order.getUser());
        return orderRepository.save(toUpdate);
    }
}
