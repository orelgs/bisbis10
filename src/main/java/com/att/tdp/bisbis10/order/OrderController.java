package com.att.tdp.bisbis10.order;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    private ResponseEntity<Order> addOrder(@Valid @RequestBody OrderDTO orderDTO) {
        Order order = orderService.addOrder(orderDTO);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
