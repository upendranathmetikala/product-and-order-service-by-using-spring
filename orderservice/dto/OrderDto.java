package org.jsp.orderservice.dto;

public class OrderDto {

	private long productId;
	
	private Integer quantity;
	
	private String paymentMode;

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

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "OrderDto [productId=" + productId + ", quantity=" + quantity + ", paymentMode=" + paymentMode + "]";
	}
	
	
}
