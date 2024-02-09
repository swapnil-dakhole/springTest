package com.cybage.dao;

import java.util.List;

import com.cybage.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProductDao {
	// object
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_unit");

	public static void addProductDetails(Product product) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(product); // insert

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	// delete product by id
	public static void deleteProductById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();

			Product product = entityManager.find(Product.class, id); // find() the on the base of primary key
			if (product != null) {
				entityManager.remove(product);
			}

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	public static void updateProductPrice(int pid, float updatedPrice) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			// get data on the basis of pid
			Product product = entityManager.find(Product.class, pid);
			if (product != null) {
				System.out.println(product);
				product.setPrice(updatedPrice);
				System.out.println(product);
				entityManager.merge(product);
			}

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	// fetch all products
	public static void getAlProducts() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query query = entityManager.createQuery("select pro from Product pro");

			List<Product> products = query.getResultList();
			System.out.println("Product Details :");
			for (Product product : products) {
				System.out.println(product);
			}

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	public static void deleteByName(String productName) { // delete by product name
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
		/*delete by find and remove() method - named query
			 * Query query =
			 * entityManager.createQuery("select pro from Product pro where pro.name=:a");
			 * query.setParameter("a", productName); List<Product> products =
			 * query.getResultList(); if (products != null) { for (Product product :
			 * products) { entityManager.remove(product); } }
			 */
			Query query = entityManager.createQuery("delete from Product pro where pro.name=?1");
			query.setParameter(1, productName);
			 query.executeUpdate();
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

	}

	public static void updateByName(String productName,String brandName, float price) { // delete by product name
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
		/*delete by find and remove() method - named query
			 * Query query =
			 * entityManager.createQuery("select pro from Product pro where pro.name=:a");
			 * query.setParameter("a", productName); List<Product> products =
			 * query.getResultList(); if (products != null) { for (Product product :
			 * products) { entityManager.remove(product); } }
			 */
			Query query = entityManager.createQuery("update Product pro set pro.brand=?1, pro.price=?2 where pro.name=?3");
			query.setParameter(1, brandName);
			query.setParameter(2, price);
			query.setParameter(3, productName);
			 query.executeUpdate();
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

	}
}
