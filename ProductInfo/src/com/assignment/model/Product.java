package com.assignment.model;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 7526472295622776147L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int rfqId;
	private String accountId;
	private int productNumber;
	private String productCategory;
	
	private int quantity;
	
	
	public Product(){}
	public Product(int rfqId, String accountId, int productNumber, String productCategory, int quantity) {
		super();
		this.rfqId = rfqId;
		this.accountId = accountId;
		this.productNumber = productNumber;
		this.productCategory = productCategory;
		this.quantity = quantity;
	}
	
	public int getRfqId() {
		return rfqId;
	}
	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
