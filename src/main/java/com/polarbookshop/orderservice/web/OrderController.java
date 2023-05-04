package com.polarbookshop.orderservice.web;

import com.polarbookshop.orderservice.domain.Order;
import org.springframework.web.bind.annotation.*;

import com.polarbookshop.orderservice.domain.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import jakarta.validation.Valid;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Mono<Order> submitOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.submitOrder(orderRequest.getIsbn(), orderRequest.getQuantity());
    }

}
