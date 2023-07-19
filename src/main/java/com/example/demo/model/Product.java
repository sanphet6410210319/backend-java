package com.example.demo.model;


public class Product {
	private Integer productId;
	private String ProductName;
	private Integer productPrice;
	private Integer productAmount;
	private String productDetail;
	
	public Product(Integer productId, String ProductName, Integer productPrice, Integer productAmount ,String productDetail) {
		super();
		this.productId = productId;
		this.ProductName = ProductName;
		this.productPrice = productPrice;
		this.productAmount = productAmount;
		this.productDetail = productDetail;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	
}