package com.GrocerySystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyGrocery")
public class MyGroceryList {
	
	@Id
	private int id;
	private String name;
	private String product;
	private String price;
	public MyGroceryList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyGroceryList(int id, String name, String product, String price) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
