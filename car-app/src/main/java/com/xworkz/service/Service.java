package com.xworkz.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.dto.CarDTO;
import com.xworkz.entity.CarEntity;

public interface Service {

	boolean validateAllDetails(CarDTO carDTO);
	
    boolean saveAll(CarDTO carDTO);
    
    boolean validateCarName(String name);
    
    public CarEntity findCarByName(String name);

 }
