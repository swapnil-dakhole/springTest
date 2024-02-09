package com.cybage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.cybage.dao.CustomerDao;
import com.cybage.dao.ProductDao;
import com.cybage.model.Customer;
import com.cybage.model.Product;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// Insert Code :-
			
			/*
			 * System.out.println("Enter product name, brand, price: "); Product product =
			 * new Product(); product.setName(br.readLine());
			 * product.setBrand(br.readLine());
			 * product.setPrice(Float.parseFloat(br.readLine()));
			 * 
			 * ProductDao.addProductDetails(product);
			 */
			  
			  
			/*  // Delete product /*
			  System.out.println("Enter Product Id to delete Record: ");
			  ProductDao.deleteProductById(Integer.parseInt(br.readLine()));
			 */

			/*
			 * Update product using id System.out.println("Enter product id,  price: ");
			 * ProductDao.updateProductPrice(Integer.parseInt(br.readLine()),
			 * Float.parseFloat(br.readLine()));
			 */
//			ProductDao.getAlProducts();
			// **** Delete Records******
			/*
			 * System.out.println("Enter Product name for delete Record: ");
			 * ProductDao.deleteByName(br.readLine());
			 */
			// **************** updating brand and price using name **********
			  System.out.println("Enter Product name for updating brand and price ");
			  ProductDao.updateByName(br.readLine(), br.readLine(),
			  Float.parseFloat(br.readLine()));
			 
			/*
			 * Customer customer; int choice;
			 * 
			 * System.out.println("Choose an operation:");
			 * System.out.println("1. Add Customer Details");
			 * System.out.println("2. Delete Customer by ID");
			 * System.out.println("3. Update Customer Address by ID");
			 * System.out.print("Enter your choice: "); choice =
			 * Integer.parseInt(br.readLine());
			 * 
			 * switch (choice) { case 1: // insert customer into database
			 * System.out.println("Enter customer Name, Age, and Address :"); customer = new
			 * Customer(); customer.setCustName(br.readLine());
			 * customer.setCustAge(Integer.parseInt(br.readLine()));
			 * customer.setAddress(br.readLine()); CustomerDao.addCustomerDetails(customer);
			 * break; case 2: // delete customer using id
			 * System.out.println("Enter customer id for delete :");
			 * CustomerDao.deleteCustomerById(Integer.parseInt(br.readLine())); break; case
			 * 3: // update customer address using id
			 * System.out.println("Enter customer id and updated address:");
			 * CustomerDao.updateCustomerAddress(Integer.parseInt(br.readLine()),
			 * br.readLine()); break; default: System.out.println("Invalid choice!"); break;
			 * }
			 */
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
