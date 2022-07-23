package com.xworkz.dao;

import com.xworkz.entity.CarEntity;

public interface CarDAO {

	boolean saveCar( CarEntity carEntity); 
   public CarEntity findCarByName(String name);
}
