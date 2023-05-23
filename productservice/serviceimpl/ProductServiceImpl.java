package org.jsp.productservice.serviceimpl;

import java.util.List;
import org.jsp.productservice.entity.ProductEntity;
import org.jsp.productservice.repositoryimpl.ProductRepositoryImpl;
import org.jsp.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;

	@Override
	public ProductEntity saveProduct(ProductEntity productEntity) {
		return productRepositoryImpl.saveProduct(productEntity);	
	}

	@Override
	public ProductEntity findProductById(long id) {
		return productRepositoryImpl.findProductById(id);	
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		return productRepositoryImpl.findAllProducts();
	}

	@Override
	public Integer findProductQuantityById(long id) {
		return productRepositoryImpl.findProductQuantityById(id);
	}

	@Override
	public ProductEntity deleteProductById(long id) {
		return productRepositoryImpl.deleteProductById(id);
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) {
		return productRepositoryImpl.updateProduct(productEntity);
	}

	@Override
	public List<ProductEntity> findAllProductSortedByName() {
		return productRepositoryImpl.findAllProductSortedByName();
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {
		return productRepositoryImpl.getProductByName(name);
	}

	@Override
	public List<ProductEntity> getProductInRange(Double lowerPrice, Double higherPrice) {
		
		return productRepositoryImpl.getProductInRange(lowerPrice, higherPrice);
	}

	@Override
	public Double findProductPriceById(long id) {
	
		return productRepositoryImpl.findProductPriceById(id);
	}

}
