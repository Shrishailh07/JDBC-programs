package com.xworkz.tv.dao;

import com.xworkz.tv.entity.TVChannel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TVChannelDAOImpl implements TVChannelDAO {
	@Override
	public void saveChannel(TVChannel tvchannel) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		EntityTransaction tx = null;

		try {
			factory = Persistence.createEntityManagerFactory("monster");
			entityManager = factory.createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(tvchannel);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}

	@Override
	public void getChannel() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		EntityTransaction tx = null;

		try {
			factory = Persistence.createEntityManagerFactory("monster");
			entityManager = factory.createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			TVChannel channel=entityManager.find(TVChannel.class, 1);
			System.out.println(channel.toString());
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}
