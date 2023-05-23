package org.jsp.productservice.repositoryimpl;

import java.util.List;

import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jsp.productservice.entity.ProductEntity;
import org.jsp.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ProductEntity saveProduct(ProductEntity productEntity) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Object object = session.merge(productEntity);
		transaction.commit();
		return (ProductEntity)object;
	}

	@Override
	public ProductEntity findProductById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ProductEntity productEntity = session.get(ProductEntity.class, id);
		transaction.commit();
		return productEntity;
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		String querry="FROM ProductEntity";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(querry);
		return query.getResultList(); 
	}

	@Override
	public Integer findProductQuantityById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		return (session.get(ProductEntity.class, id)).getQuantity();
	}

	@Override
	public ProductEntity deleteProductById(long id) {
		ProductEntity productEntity = findProductById(id);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(productEntity);
		transaction.commit();
		return productEntity;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Object object = session.merge(productEntity);
		transaction.commit();
		return (ProductEntity)object;
	}

	@Override
	public List<ProductEntity> findAllProductSortedByName() {
		String query="FROM ProductEntity";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query2 = session.createQuery(query);
		List<ProductEntity> list = query2.getResultList();
		List<ProductEntity> li = list.stream().sorted((e1,e2)->e1.getName().compareToIgnoreCase(e2.getName())).collect(Collectors.toList());
		return li;
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {
		
		String query="FROM ProductEntity WHERE name=:n";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query2 = session.createQuery(query);
		query2.setParameter("n", name);
		return query2.getResultList();
		
	}

	@Override
	public List<ProductEntity> getProductInRange(Double lowerPrice, Double higherPrice) {
		
		String query="FROM ProductEntity WHERE price>=:l AND price<=:h";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query2 = session.createQuery(query);
		query2.setParameter("l", lowerPrice);
		query2.setParameter("h", higherPrice);
		return query2.getResultList(); 
	}

	@Override
	public Double findProductPriceById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		return (session.get(ProductEntity.class, id)).getPrice(); 
	}
	
	
}
