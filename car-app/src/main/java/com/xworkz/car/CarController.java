package com.xworkz.car;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.dto.CarDTO;
import com.xworkz.entity.CarEntity;
import com.xworkz.service.Service;
import com.xworkz.service.ServiceImpl;

@Component
@RequestMapping("/")
public class CarController {
	
@Autowired	
private Service service;

public CarController() {
System.out.println(getClass().getSimpleName()+" created");
}

@RequestMapping("/getValues")
public String getValues() {
	System.out.println("Invoked getValues()");
	return "/WEB-INF/car.jsp";
}

@RequestMapping("/readValues")
public String readValues( @ModelAttribute CarDTO carDTO ,Model model) {
    System.out.println("Invoked readValues()");
	System.out.println("Car name : "+carDTO.getName());
	System.out.println("Car colour : "+carDTO.getColour());
	System.out.println("Car speed : "+carDTO.getSpeed());
	System.out.println("Car seats : "+carDTO.getSeats());
	System.out.println("Car price : "+carDTO.getPrice());
	
	boolean valid = this.service.validateAllDetails(carDTO);
	System.out.println(valid);
	
	if(valid) {
		System.out.println("Data is Valid");
		boolean result=this.service.saveAll(carDTO);
		System.out.println(result);
		
		if(result=true) {
			System.out.println("Saved to Database");
		}
		else {
			System.out.println("Not Saved to Database");
		}
	}
	
	else {
		System.out.println("Data is Not Valid");
		Map<String, String> map = ServiceImpl.map;
		model.addAttribute("errorName",map.get("NAME"));
		model.addAttribute("errorColour",map.get("COLOUR"));
		model.addAttribute("errorSpeed",map.get("SPEED"));
		model.addAttribute("errorSeats",map.get("SEATS"));
		model.addAttribute("errorPrice",map.get("PRICE"));
	}
	return "/WEB-INF/car.jsp";
}

@RequestMapping(value = "/searchCarByName")
public String searchCarByName(@RequestParam String name, Model model) {
	System.out.println("Invoked searchCarByName() CarName : "+name);
	
	boolean carNameValid = this.service.validateCarName(name);
	
	if(carNameValid) {
		System.out.println("carName is Valid");
		
		CarEntity carEntity = this.service.findCarByName(name);
		
		if(carEntity!=null) {
			
        model.addAttribute("CarName",carEntity.getName());
        model.addAttribute("CarColour", carEntity.getColour());
        model.addAttribute("CarSpeed", carEntity.getSpeed());
        model.addAttribute("CarSeats", carEntity.getSeats());
        model.addAttribute("CarPrice", carEntity.getPrice());
		}
		else {
			model.addAttribute("ErrorCarName","Results not Found for "+name);
		}
	}
	else {
		model.addAttribute("ErrorCarName"," Car Not Found");
	}
	return "/WEB-INF/car.jsp";
  }
}