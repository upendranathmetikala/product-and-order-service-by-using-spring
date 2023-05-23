package org.jsp.orderservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orderservice_info")
public class OrderEntity implements Serializable{
	
	@Id
	@GenericGenerator(name="auto_gen", strategy="increment")
	@GeneratedValue(generator = "auto_gen")
	@Column(name="alt_key")
	private long altKey;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="total_price")
	private Double totalPrice;
	
	@Column(name="payment_mode")
	private String paymentMode;
	
	@Column(name="sold_date")
	private Date soldDate;

	public long getAltKey() {
		return altKey;
	}

	public void setAltKey(long altKey) {
		this.altKey = altKey;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

	@Override
	public String toString() {
		return "OrderEntity [altKey=" + altKey + ", productId=" + productId + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", paymentMode=" + paymentMode + ", soldDate=" + soldDate + "]";
	}
	
	
}
