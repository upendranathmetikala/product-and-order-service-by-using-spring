package org.jsp.productservice.service;

import java.util.List;

import org.jsp.productservice.entity.ProductEntity;

public interface ProductService {
	
	public ProductEntity saveProduct(ProductEntity productEntity);
	
	public ProductEntity findProductById(long id);
	
	public List<ProductEntity> findAllProducts();
	
	public Integer findProductQuantityById(long id);
	
	public ProductEntity deleteProductById(long id);
	
	public ProductEntity updateProduct(ProductEntity productEntity);
	
	public List<ProductEntity> findAllProductSortedByName();
	
	public List<ProductEntity> getProductByName(String name);
	
	public List<ProductEntity> getProductInRange(Double lowerPrice, Double higherPrice);
	
	public Double findProductPriceById(long id);
}
