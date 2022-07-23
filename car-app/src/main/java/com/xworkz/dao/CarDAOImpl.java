package com.xworkz.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.entity.CarEntity;

@Component
public class CarDAOImpl implements CarDAO{

	
	public CarDAOImpl() {
System.out.println("CarDAOImpl created");
	}

	@Autowired
	private SessionFactory sessionFactory;
	Session session = null;
	
public boolean saveCar(CarEntity carEntity) {

	try {
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(carEntity);
		transaction.commit();
	} catch (Exception e) {
		
	}
	finally {
		if(session!=null) {
			session.close();
			System.out.println("session is closed");
		}
		else {
			System.out.println("session is not closed");
		}
	}
	return false;
	
}

@Override
public CarEntity findCarByName(String name) {
	System.out.println("Invoked findCarByName() from CarDAOImpl");
	Session session = null;
	CarEntity carEntity=null;
	try {
		session = sessionFactory.openSession();
		Query query = session.createNamedQuery("CarEntity.findCarByName");
		query.setParameter("NAME",name);
		Object object = query.uniqueResult();
		carEntity = (CarEntity)object;
		
		if(carEntity!=null) {
			return carEntity;
		}
		else {
			System.out.println("CarEntity not found");
		}
	} catch (HibernateException e) {
		System.out.println("HibernateException");
	}
	
	finally {
		if (session!=null) {
			session.close();
			System.out.println("session is closed");
		}
		else {
			System.out.println("session is not closed");
		}
	}
	return carEntity;
 }


}

