package com.xworkz.hibernatedemo;

import com.xworkz.hibernatedemo.entity.RestaurantEntity;
import com.xworkz.hibernatedemo.dao.RestaurantDAO;
public class Runner 
{
public static void main(String[] args)
{
RestaurantEntity restaurantEntity = new RestaurantEntity();
restaurantEntity.setRestaurantId(1);
restaurantEntity.setContactNo(7795423);
restaurantEntity.setName("Basaveshwara Lingayat Kanavali");
restaurantEntity.setRating(9.5);
restaurantEntity.setType("Veg");
RestaurantDAO restaurantDAO = new RestaurantDAO();
restaurantDAO.saveRestaurant(restaurantEntity);
System.out.println("Saved Successfully");

}
}
