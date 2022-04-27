package com.xworkz.hibernatedemo.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import com.xworkz.hibernatedemo.entity.RestaurantEntity;
import org.hibernate.*;

public class RestaurantDAO 
{
public void saveRestaurant(RestaurantEntity entity)
{
Configuration cfg = new Configuration();
cfg.configure();

SessionFactory sessionFactory = cfg.buildSessionFactory();

Session session = sessionFactory.openSession();

Transaction tx = session.beginTransaction();

session.persist(entity);

tx.commit();
}
}