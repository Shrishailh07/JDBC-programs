package com.xworkz.hibernatedemo.entity;

import com.xworkz.hibernatedemo.dao.RestaurantDAO;
import com.xworkz.hibernatedemo.dao.RestaurantJpaDao;

public class JpaTester 
{
		
		public static void main(String[] args) {
			
			RestaurantEntity entity = new RestaurantEntity();
			entity.setContactNo(125478);
			entity.setType("veg");
			entity.setName("Mirchi Veeranna");
			entity.setRestaurantId(3);
			entity.setRating(5);
			
			RestaurantJpaDao jpaDao=new RestaurantJpaDao();
			jpaDao.saveRestaurantJPA(entity);
			System.out.println("saved sucessfully....!");
		}

	}

