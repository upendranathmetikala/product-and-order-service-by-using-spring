package org.jsp.orderservice.repositoryimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jsp.orderservice.entity.OrderEntity;
import org.jsp.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrder(OrderEntity entity) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Object object = session.merge(entity);
		transaction.commit();
	}

}
