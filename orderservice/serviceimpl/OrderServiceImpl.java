package org.jsp.orderservice.serviceimpl;

import java.util.Date;

import org.jsp.orderservice.dto.OrderDto;
import org.jsp.orderservice.entity.OrderEntity;
import org.jsp.orderservice.repositoryimpl.OrderRepositoryImpl;
import org.jsp.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepositoryImpl orderRepositoryImpl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String processOrder(OrderDto orderDto) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("http://localhost:8080/productservice/findProductPriceById/");
		builder.append(orderDto.getProductId());
		Double price = restTemplate.getForObject(builder.toString(), Double.class);
	
		OrderEntity entity = new OrderEntity();
		entity.setProductId(orderDto.getProductId());
		entity.setQuantity(orderDto.getQuantity());
		entity.setPaymentMode(orderDto.getPaymentMode());
		entity.setTotalPrice(orderDto.getQuantity()*price);
		entity.setSoldDate(new Date());
		System.out.println(entity);
		orderRepositoryImpl.saveOrder(entity);
		return "order placed successfully";
	}

}
