package com.cybage.dao;

import com.cybage.model.Customer;
import com.cybage.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerDao {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_unit");

	public static void addCustomerDetails(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(customer); // insert

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}
	public static void deleteCustomerById(int cid) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();

			Customer customer = entityManager.find(Customer.class, cid);
			if(customer!=null) {
				entityManager.remove(customer);
			}
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}
	public static void updateCustomerAddress(int cid, String updatedAddress) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();

			Customer customer = entityManager.find(Customer.class, cid);
			if(customer!=null) {
				customer.setAddress(updatedAddress);
				entityManager.merge(customer);
			}
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}
}
