package org.jsp.productservice.controller;

import java.util.List;

import org.jsp.productservice.entity.ProductEntity;
import org.jsp.productservice.serviceimpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.javafx.collections.MappingChange.Map;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PostMapping(value="/saveProduct")
	public ProductEntity saveProduct(@RequestBody ProductEntity productEntity) {
		productServiceImpl.saveProduct(productEntity);
		return productEntity;
	}
	
	@PostMapping(value="/findProductById/{altKey}")
	public ProductEntity findProductById(@PathVariable("altKey") long id) {
		return productServiceImpl.findProductById(id);	
	}
	
	@GetMapping(value="/findAllProducts")
	public List<ProductEntity> findAllProducts(){
		return productServiceImpl.findAllProducts();	
	}
	
	@GetMapping(value="/findProductQuantityById/{altKey}")
	public Integer findProductQuantityById(@PathVariable("altKey") long id) {
		return productServiceImpl.findProductQuantityById(id);
	}
	
	@GetMapping(value="/findProductPriceById/{altKey}")
	public Double findProductPriceById(@PathVariable("altKey") long id) {
		return productServiceImpl.findProductPriceById(id);
	}
	
	@DeleteMapping(value="/deleteProductById/{altKey}")
	public ProductEntity deleteProductById(@PathVariable("altKey") long id) {
		return productServiceImpl.deleteProductById(id);	
	}
	
	@PutMapping(value="/updateProduct")
	public ProductEntity updateProduct(@RequestBody ProductEntity productEntity) {
		return productServiceImpl.updateProduct(productEntity);
	}
	
	@GetMapping(value="/findAllProductSortedByName")
	public List<ProductEntity> findAllProductSortedByName(){
		return productServiceImpl.findAllProductSortedByName();
		
	}
	
	@GetMapping(value="/getProductByName")
	public List<ProductEntity> getProductByName(@RequestParam("name") String name){
		
		return productServiceImpl.getProductByName(name);
		
	}
	
	@GetMapping(value="/getProductInRange")
	public @ResponseBody List<ProductEntity> getProductInRange(@RequestParam("lower") Double lowerPrice,@RequestParam("higher") Double higherPrice){
		
		return productServiceImpl.getProductInRange(lowerPrice, higherPrice);
	}
}
