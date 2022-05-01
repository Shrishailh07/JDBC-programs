package com.xworkz.clothes.impl;
	import java.util.Date;
	import com.xworkz.clothes.dao.ClothesDAO;
	import com.xworkz.clothes.entity.ClothesEntity;
	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.EntityTransaction;
	import jakarta.persistence.Persistence;

	public class ClothesImpl implements ClothesDAO {

		private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clothes");

		public void saveClothes(ClothesEntity clothesEntity) {
			EntityManager entityManager = null;
			EntityTransaction entityTransaction = null;
			try {
				entityManager = entityManagerFactory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(clothesEntity);
				entityTransaction.commit();
			} catch (Exception e) {
				entityTransaction.rollback();
				e.printStackTrace();
			} finally {
				entityManager.close();
			}
		}

		public ClothesEntity getClothesById(int clothId) {
			EntityManager entityManager = null;
			try {
				entityManager = entityManagerFactory.createEntityManager();
				entityManager.find(ClothesEntity.class, clothId);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				entityManager.close();
			}
			return null;
		}

		public void updateClotheBrandAndPriceById(String brand, double price, int id) {
			EntityManager entityManager = null;
			EntityTransaction entityTransaction = null;
			try {
				entityManager = entityManagerFactory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				ClothesEntity clo = entityManager.find(ClothesEntity.class, id);
				clo.setBrand(brand);
				clo.setPrice(price);
				entityTransaction.commit();
			} catch (Exception e) {
				entityTransaction.rollback();
				e.printStackTrace();
			} finally {
				entityManager.close();
			}
		}

		public void deleteById(int id) {
			EntityManager entityManager = null;
			EntityTransaction entityTransaction = null;
			try {
				entityManager = entityManagerFactory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				ClothesEntity clo = entityManager.find(ClothesEntity.class, id);
				entityManager.remove(clo);
				entityTransaction.commit();
			} catch (Exception e) {
				entityTransaction.rollback();
				e.printStackTrace();
			} finally {
				entityManager.close();
			}
		}

		public void updatemanufacturedYearById(Date manufacturedYear, int id) {
			EntityManager entityManager = null;
			EntityTransaction entityTransaction = null;
			Date date = null;
			try {

				entityManager = entityManagerFactory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();

				ClothesEntity clo = entityManager.find(ClothesEntity.class, id);

				clo.setYear(date);
				entityManager.merge(clo);
				entityTransaction.commit();

			} catch (Exception e) {
				entityTransaction.rollback();
				e.printStackTrace();
			} finally {
				if (entityManager != null) {
					entityManager.close();
				}
			}
		}

	}


