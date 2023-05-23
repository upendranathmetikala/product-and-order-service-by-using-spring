package org.jsp.orderservice.controller;

import org.jsp.orderservice.dto.OrderDto;
import org.jsp.orderservice.serviceimpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping(value="/processOrder")
	public String processOrder(@RequestBody OrderDto orderDto) {
		
		return orderServiceImpl.processOrder(orderDto);
	}
}
