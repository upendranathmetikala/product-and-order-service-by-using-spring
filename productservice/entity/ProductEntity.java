package org.jsp.productservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@Table(name="productservice_info")
public class ProductEntity implements Serializable{
	
	@Id
	@GenericGenerator(name="auto_gen", strategy="increment")
	@GeneratedValue(generator = "auto_gen")
	@Column(name="alt_key")
	private long altKey;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="description")
	private String description;

	public long getAltKey() {
		return altKey;
	}

	public void setAltKey(long altKey) {
		this.altKey = altKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductEntity [altKey=" + altKey + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", description=" + description + "]";
	}
	
	
}
