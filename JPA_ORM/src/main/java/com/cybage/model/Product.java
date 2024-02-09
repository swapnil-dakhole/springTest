package com.cybage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//for creating table in database :-
@Entity  
@Table(name = "ProductInfo")
public class Product {
	@Id // for making this pid as primary key 
	@GeneratedValue(strategy = GenerationType.AUTO) // for auto_increment
	@Column(name = "productID") // providing name to column of TABLE
	private int pid;
	@Column(name = "productName")
	private String name;
	@Column(name = "productBrand")
	private String brand;
	private float price;
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
		
	
}
