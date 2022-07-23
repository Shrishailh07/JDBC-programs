package com.xworkz.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.dao.CarDAO;
import com.xworkz.dao.CarDAOImpl;
import com.xworkz.dto.CarDTO;
import com.xworkz.entity.CarEntity;

@Component
public class ServiceImpl implements Service {


@Autowired
private CarDAO carDAO;

public static Map<String, String> map = new HashMap<>();

	public ServiceImpl(){
   System.out.println("ServiceImpl created");
	}
	
	@Override
	public boolean validateAllDetails(CarDTO carDTO) {
		boolean flag=false;
		if(carDTO.getName()!=null &&! carDTO.getName().isEmpty() &&! carDTO.getName().isBlank()) {
			flag=true;
			System.out.println("Name is valid : "+carDTO.getName());
		   }
			else {
				flag=false;
				System.out.println("Name is not valid : ");
				map.put("NAME", "Name is Invalid");
				return flag;
			}
		
		
		if(carDTO.getColour()!=null &&! carDTO.getColour().isEmpty() &&! carDTO.getColour().isBlank()) {
			flag=true;
			System.out.println("Colour is valid : "+carDTO.getColour());
		    }
			else {
				flag=false;
				System.out.println("Colour is not valid : ");
				map.put("COLOUR", "Colour is Invalid");
				return flag;
			}
		
		
		if(carDTO.getSpeed()>0) {
			flag=true;
			System.out.println("Speed is valid : "+carDTO.getSpeed());
		}
		else {
			flag=false;
			System.out.println("Speed is not value : ");
            map.put("SPEED", "Speed is Invalid");
			return flag;
		}
		
		
		if(carDTO.getSeats()>=2) {
			flag=true;
			System.out.println("Seats are valid : "+carDTO.getSeats());
		}
		else {
			flag=false;
			System.out.println("Seats are not valid : ");
             map.put("SEATS","Seats are Invalid");
			return flag;
		}
		
		
		if(carDTO.getPrice()>100000) {
			flag=true;
			System.out.println("Price is valid : "+carDTO.getPrice());
		}
		else {
			flag=false;
			System.out.println("Price is not valid : ");
			map.put("PRICE", "Price is Invalid");
			return flag;
		}
	    
		return flag;
	}

	@Override
	public boolean saveAll(CarDTO carDTO) {
		CarEntity carEntity = new CarEntity(carDTO.getName(), carDTO.getColour(), carDTO.getSpeed(), carDTO.getSeats(), carDTO.getPrice());
		
		boolean carsaved=this.carDAO.saveCar(carEntity);
	
		return false;
	}

	@Override
	public boolean validateCarName(String name) {
//		boolean flag=false;
		try { 
            return name!=null && !name.isEmpty() && !name.isBlank() ? true : false;
//			if(name!=null && !name.isEmpty() && !name.isBlank() ) {
//				flag=true;
//		    	 System.out.println("Invoked validateCarName()"+name); 
//		       }
//		     else {
//		    	 flag=false;
//		    	 System.out.println("Not Invoked validateCarName()");
//			    }
			
		} catch (RuntimeException e) {
           System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public CarEntity findCarByName(String name) {
		try {
			System.out.println("Invoked findCarByName()");

		} catch (Exception e) {
		}
		return this.carDAO.findCarByName(name);
	}

	
}
