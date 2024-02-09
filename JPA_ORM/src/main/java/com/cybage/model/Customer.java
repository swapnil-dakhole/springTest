package com.cybage.model;

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
@Table(name = "CustomerDetails")
public class Customer {
	@Id // for making this pid as primary key 
	@GeneratedValue(strategy = GenerationType.AUTO) // for auto_increment
	private int cid;
	private String custName;
	private int custAge;
	private String address;
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", custName=" + custName + ", custAge=" + custAge + ", address=" + address
				+ "]";
	}
	
}
