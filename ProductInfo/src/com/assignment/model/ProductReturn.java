package com.assignment.model;

import java.io.Serializable;

public class ProductReturn implements Serializable{
	private static final long serialVersionUID = 7526472295622776147L;
	private int rfqId;
	private String accountId;
	private int productNumber;
	private String productCategory;
	private int quantity;
	private int totalPrice;
	private String currency;
	private String validationPeriod;
	
	public ProductReturn(){}
	public ProductReturn(int rfqId, String accountId, int productNumber, String productCategory, int quantity, int totalPrice,
			String currency, String validateionPeriod) {
		super();
		this.rfqId = rfqId;
		this.accountId = accountId;
		this.productNumber = productNumber;
		this.productCategory = productCategory;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.currency = currency;
		this.validationPeriod = validateionPeriod;
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
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int price) {
		this.totalPrice = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getValidationPeriod() {
		return validationPeriod;
	}
	public void setValidationPeriod(String validateionPeriod) {
		this.validationPeriod = validateionPeriod;
	}
}
