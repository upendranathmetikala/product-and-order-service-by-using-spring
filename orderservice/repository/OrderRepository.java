package org.jsp.orderservice.repository;

import org.jsp.orderservice.entity.OrderEntity;

public interface OrderRepository {

	public void saveOrder(OrderEntity entity);
}
